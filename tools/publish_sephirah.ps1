<#
.SYNOPSIS
Publishes the local Sephirah repository to GitHub using GitHub CLI.

Run from the local Sephirah repo root after reviewing git status.

.EXAMPLE
.\tools\publish_sephirah.ps1 -Visibility public

.EXAMPLE
.\tools\publish_sephirah.ps1 -Visibility private -RepoName sephirah
#>

param(
    [ValidateSet("public", "private")]
    [string]$Visibility = "public",

    [string]$Owner = "bmharter",

    [string]$RepoName = "sephirah",

    [string]$Description = "Xtext-based expression language for readable, validated formulas and rule-system computations.",

    [string]$CommitMessage = "Prepare Sephirah for GitHub portfolio demo"
)

$ErrorActionPreference = "Stop"

function Require-Command($Name) {
    if (-not (Get-Command $Name -ErrorAction SilentlyContinue)) {
        throw "Required command '$Name' was not found on PATH."
    }
}

Require-Command git
Require-Command gh

Write-Host "Checking GitHub CLI authentication..." -ForegroundColor Cyan
gh auth status

if (-not (Test-Path ".git")) {
    Write-Host "Initializing Git repository on main..." -ForegroundColor Cyan
    git init -b main
}

Write-Host "Running repo health check..." -ForegroundColor Cyan
& "$PSScriptRoot\..\repo_health_check.ps1"

Write-Host "\nCurrent git status:" -ForegroundColor Cyan
git status -sb

$confirmation = Read-Host "Stage and commit the current repo contents for GitHub publication? Type YES to continue"
if ($confirmation -ne "YES") {
    Write-Host "Canceled before staging." -ForegroundColor Yellow
    exit 1
}

git add README.md .gitignore docs examples tools

# Add the Xtext/Eclipse projects if present.
Get-ChildItem -Directory -Filter "com.fearlesstyrant.sephirah*" | ForEach-Object {
    git add $_.FullName
}

$hasChanges = git status --porcelain
if ($hasChanges) {
    git commit -m $CommitMessage
} else {
    Write-Host "No changes to commit." -ForegroundColor Yellow
}

$currentBranch = git branch --show-current
if (-not $currentBranch) {
    $currentBranch = "main"
}

# Create remote repo if origin does not exist.
$origin = git remote get-url origin 2>$null
if (-not $origin) {
    $visibilityFlag = "--$Visibility"
    $fullName = "$Owner/$RepoName"
    Write-Host "Creating GitHub repo $fullName..." -ForegroundColor Cyan
    gh repo create $fullName $visibilityFlag --description $Description --source . --remote origin --push
} else {
    Write-Host "Remote origin already exists: $origin" -ForegroundColor Cyan
    git push -u origin $currentBranch
}

Write-Host "\nPublished Sephirah to GitHub." -ForegroundColor Green
Write-Host "Open it with: gh repo view --web"


<#
.SYNOPSIS
Checks that the Sephirah repo is safe to publish.

Run from the intended repository root.
#>

$ErrorActionPreference = "Stop"

Write-Host "Sephirah repo health check" -ForegroundColor Cyan

$root = (Get-Location).Path
Write-Host "Root: $root"

$badDirs = @(".metadata", ".recommenders", "RemoteSystemsTempFiles")
$foundBad = @()
foreach ($dir in $badDirs) {
    if (Test-Path (Join-Path $root $dir)) {
        $foundBad += $dir
    }
}

if ($foundBad.Count -gt 0) {
    Write-Error "This looks like an Eclipse workspace root, not a clean repo root. Found: $($foundBad -join ', ')"
}

$expectedDirs = @(
    "com.fearlesstyrant.sephirah",
    "com.fearlesstyrant.sephirah.ide",
    "com.fearlesstyrant.sephirah.ui",
    "com.fearlesstyrant.sephirah.tests",
    "com.fearlesstyrant.sephirah.ui.tests"
)

$missingExpected = @()
foreach ($dir in $expectedDirs) {
    if (-not (Test-Path (Join-Path $root $dir))) {
        $missingExpected += $dir
    }
}

if ($missingExpected.Count -gt 0) {
    Write-Warning "Some expected Sephirah project folders were not found: $($missingExpected -join ', ')"
    Write-Warning "Continue only if the project was intentionally reorganized."
}

if (-not (Test-Path (Join-Path $root ".git"))) {
    Write-Warning "No .git folder found. Run 'git init -b main' before publishing."
}

Write-Host "\nGit status:" -ForegroundColor Cyan
git status -sb

Write-Host "\nChecking for generated files that should usually remain untracked..." -ForegroundColor Cyan
$generated = git status --short | Select-String -Pattern "(^\?\?|^ A|^A )\s+(.*/)?(bin|target|build|features|plugins)/"
if ($generated) {
    Write-Warning "Possible generated output appears in git status:"
    $generated | ForEach-Object { Write-Host $_.Line }
} else {
    Write-Host "No obvious generated output staged/tracked from status view."
}

Write-Host "\nHealth check complete." -ForegroundColor Green

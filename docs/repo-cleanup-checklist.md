# Sephirah GitHub Cleanup Checklist

Use this before the first public push.

## 1. Confirm the repo root

The repo root should contain project folders such as:

```text
com.fearlesstyrant.sephirah
com.fearlesstyrant.sephirah.ide
com.fearlesstyrant.sephirah.ui
com.fearlesstyrant.sephirah.tests
com.fearlesstyrant.sephirah.ui.tests
```

It should **not** contain Eclipse workspace metadata:

```text
.metadata
.recommenders
RemoteSystemsTempFiles
```

If `.metadata` appears in `git status`, stop and move the Git repo to the actual project root.

## 2. Move feature/update-site projects into the repo

Earlier project state indicated these were created in the Eclipse workspace and may need to be moved into the repo root:

```text
com.fearlesstyrant.sephirah.feature
com.fearlesstyrant.sephirah.updatesite
```

Commit source/config files such as:

```text
feature.xml
site.xml
.project
build.properties
META-INF/MANIFEST.MF
```

Do **not** commit generated outputs unless you intentionally want versioned release artifacts:

```text
bin/
target/
features/
plugins/
```

## 3. Build/test locally

Use whatever currently works in the project:

```powershell
mvn test
mvn verify
```

If there is no root Maven aggregator yet, document the manual Eclipse/Xtext validation workflow in the README instead of adding a failing GitHub Action.

## 4. First public commit

Recommended initial commit message:

```text
Prepare Sephirah for GitHub portfolio demo
```

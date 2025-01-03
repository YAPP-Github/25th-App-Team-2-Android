#!/usr/bin/env bash

# 현재 디렉터리 설정
LINTER_CURRENT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
PROJECT_ROOT="$LINTER_CURRENT_DIR/.."
GRADLEW_SCRIPT_PATH="$LINTER_CURRENT_DIR/../gradlew"
GIT_HOOK_DIR="$LINTER_CURRENT_DIR/../.git/hooks"
DETEKT_TARGET_FILE="$GIT_HOOK_DIR/pre-push"
KTLINT_TARGET_FILE="$GIT_HOOK_DIR/pre-commit"
DETEKT_HOOK_SCRIPT="$LINTER_CURRENT_DIR/detekt_hook_script"

# Git 저장소 확인
if ! git rev-parse --is-inside-work-tree &> /dev/null
then
    echo "Error: Current directory is not a Git repository!"
    exit 1
fi

# Gradle Wrapper 확인
if [[ ! -f "$GRADLEW_SCRIPT_PATH" ]]
then
    echo "Error: Gradle Wrapper not found at $GRADLEW_SCRIPT_PATH"
    exit 1
fi

# Git Hook 디렉터리 생성
if [[ ! -d "$GIT_HOOK_DIR" ]]
then
    mkdir -p "$GIT_HOOK_DIR"
fi

# Detekt pre-push Hook 설치 확인
if [[ -f "$DETEKT_TARGET_FILE" ]]
then
    echo "*************************************************"
    echo "            Detekt integration failed            "
    echo "*************************************************"
    echo "Reason: GIT pre-push hook is already installed!"
    exit 1
fi

# KtLint Git Hooks pre-commit 추가
cd "$PROJECT_ROOT" || exit # 프로젝트 루트로 이동해야만 아래 명령어 작동
eval "$GRADLEW_SCRIPT_PATH addKtlintCheckGitPreCommitHook"
chmod +x "$KTLINT_TARGET_FILE"

# Detekt Hook 추가
if [[ ! -f "$DETEKT_HOOK_SCRIPT" ]]
then
    echo "Error: Detekt hook script not found at $DETEKT_HOOK_SCRIPT"
    exit 1
fi

cat "$DETEKT_HOOK_SCRIPT" > "$DETEKT_TARGET_FILE"
chmod +x "$DETEKT_TARGET_FILE"

echo "************************************************"
echo "                Linter installed                "
echo "************************************************"
echo "Install path: $(ls "$GIT_HOOK_DIR")"

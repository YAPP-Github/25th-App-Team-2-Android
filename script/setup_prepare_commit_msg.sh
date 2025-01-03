#!/usr/bin/env bash

CURRENT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
GIT_HOOK_DIR="$CURRENT_DIR/../.git/hooks"
PREPARE_COMMIT_MSG_SCRIPT="$CURRENT_DIR/prepare_commit_msg_script"
PREPARE_COMMIT_MSG_TARGET_FILE="$GIT_HOOK_DIR/prepare-commit-msg"


# Prepare commit msg Hook 추가 (지라 티켓명 자동 추가)
if [[ ! -f "$PREPARE_COMMIT_MSG_SCRIPT" ]]
then
    echo "Error: Prepare commit msg hook script not found at $PREPARE_COMMIT_MSG_SCRIPT"
    exit 1
fi

cat "$PREPARE_COMMIT_MSG_SCRIPT" > "$PREPARE_COMMIT_MSG_TARGET_FILE"
chmod +x "$PREPARE_COMMIT_MSG_TARGET_FILE"

echo "************************************************"
echo "       Prepare commit msg hook installed        "
echo "************************************************"
echo "Install path: $(ls "$GIT_HOOK_DIR")"

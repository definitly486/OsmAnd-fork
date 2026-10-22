#!/bin/sh

JAVA_TOOL_OPTIONS="-Dos.name=Linux" idprio 31 ./gradlew :OsmAnd:assembleAndroidFullLegacyArm64Release  --offline \
  --no-daemon --max-workers=2 \
  -x lintVitalAnalyzeAndroidFullLegacyArm64Release \
  -x lintVitalReportAndroidFullLegacyArm64Release \
  -x lintVitalAndroidFullLegacyArm64Release \
  "$@"
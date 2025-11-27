
set -euo pipefail


LIBS_DIR=libs
CLASSES_DIR=classes
SRC_DIR=src
JUNIT_RUNNER=$LIBS_DIR/junit-platform-console-standalone-1.10.2.jar
JACOCO_AGENT=$LIBS_DIR/jacocoagent.jar
JACOCO_CLI=$LIBS_DIR/jacococli.jar


rm -rf $CLASSES_DIR part1a.exec part1b.exec part1_coverage part1_1b_coverage
mkdir -p $CLASSES_DIR

echo "Compiling sources and tests..."
find $SRC_DIR -name "*.java" -print0 | xargs -0 javac -d $CLASSES_DIR -cp "$LIBS_DIR/*:$CLASSES_DIR"

echo "Running baseline tests with JaCoCo -> part1a.exec"
java -javaagent:$JACOCO_AGENT=destfile=part1a.exec -jar $JUNIT_RUNNER --class-path $CLASSES_DIR --scan-class-path

echo "Generating HTML report for baseline (part1_coverage)..."
java -jar $JACOCO_CLI report part1a.exec --classfiles $CLASSES_DIR --sourcefiles src/main/java --html part1_coverage


echo "Running improved tests with JaCoCo -> part1b.exec"
java -javaagent:$JACOCO_AGENT=destfile=part1b.exec -jar $JUNIT_RUNNER --class-path $CLASSES_DIR --scan-class-path

echo "Generating HTML report for improved tests (part1_1b_coverage)..."
java -jar $JACOCO_CLI report part1b.exec --classfiles $CLASSES_DIR --sourcefiles src/main/java --html part1_1b_coverage

echo "Done. Reports created: part1_coverage/index.html  and  part1_1b_coverage/index.html"


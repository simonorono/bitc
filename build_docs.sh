bash gradlew dokkaHtml
bash gradlew dokkaJavadoc

mkdir -p docs/dist

cp -R build/dokka/html docs/dist
cp -R build/dokka/javadoc docs/dist

pushd docs/dist
mv html kdoc
popd

rm -rf docs
bash gradlew dokkaHtml
bash gradlew dokkaJavadoc

mkdir -p docs

# Dokka documentation will be the main page
cp -R build/dokka/html docs

pushd docs
mv html dist
popd

# Add JavaDoc as optional
cp -R build/dokka/javadoc docs/dist

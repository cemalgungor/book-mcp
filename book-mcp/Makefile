.PHONY: build run clean

build:
	./mvnw -q -DskipTests clean package

run:
	java -jar target/book-mcp-0.0.1-SNAPSHOT.jar

clean:
	rm -rf target

build:
	@docker build --rm -t javaday .

run:
	@docker run -it javaday /bin/sh

.PHONY: clean

clean: #Tidy + rm cache
	find . -name "*.class" -type f -delete
	find . -type d -name target -prune -exec rm -rf {} +
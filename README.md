# JDK-8233747

JavaFX is crashing when calling `org.w3c.dom.Document.createAttribute(String)`
of the `Document` of the `WebEngine`.

To launch it you need to set:

	--module-path=<PATH]/lib.javafx.linux_11.0.2/lib/
	--add-modules=javafx.base,javafx.controls,javafx.graphics,javafx.media,javafx.web

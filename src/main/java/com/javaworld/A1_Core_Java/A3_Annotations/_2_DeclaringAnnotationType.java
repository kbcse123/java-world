package com.javaworld.A1_Core_Java.A3_Annotations;

import java.lang.annotation.Documented;

/**
 * 
 * 
 * Declaring an Annotation Type:
 * 
 * Many annotations replace comments in code.
 * 
 * Suppose that a software group traditionally starts the body of every class
 * with comments providing important information:
 * 
 * public class Generation3List extends Generation2List {
 * 
 * // Author: John Doe // Date: 3/17/2002 // Current revision: 6 // Last
 * modified: 4/12/2004 // By: Jane Doe // Reviewers: Alice, Bill, Cindy
 * 
 * // class code goes here
 * 
 * } To add this same metadata with an annotation, you must first define the
 * annotation type. The syntax for doing this is:
 * 
 * @interface ClassInfo { String author(); String date(); int currentRevision()
 *            default 1; String lastModified() default "N/A"; String
 *            lastModifiedBy() default "N/A"; // Note use of array String[]
 *            reviewers(); } The annotation type definition looks similar to an
 *            interface definition where the keyword interface is preceded by
 *            the at sign (@) (@ = AT, as in annotation type). Annotation types
 *            are a form of interface, which will be covered in a later lesson.
 *            For the moment, you do not need to understand interfaces.
 * 
 *            The body of the previous annotation definition contains annotation
 *            type element declarations, which look a lot like methods. Note
 *            that they can define optional default values.
 * 
 *            After the annotation type is defined, you can use annotations of
 *            that type, with the values filled in, like this:
 * 
 * @ClassInfo ( author = "John Doe", date = "3/17/2002", currentRevision = 6,
 *            lastModified = "4/12/2004", lastModifiedBy = "Jane Doe", reviewers
 *            = {"Alice", "Bob", "Cindy"} ) public class Generation3List extends
 *            Generation2List {
 * 
 *            // class code goes here
 * 
 *            } Note: To make the information in @ClassInfo appear in
 *            Javadoc-generated documentation, you must annotate the @ClassInfo
 *            definition with the @Documented annotation:
 * 
 *            // import this to use @Documented import java.lang.annotation.*;
 * 
 * @Documented
 * @interface ClassInfo {
 * 
 *            // Annotation element definitions }
 * 
 */

@Documented
@interface ClassInfo {
	String author();

	String date();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	// Note use of array
	String[] reviewers();
}

/**
 * This class is an example for creating Annotation Types.
 */
@ClassInfo(author = "Shaik Khader", date = "30/10/2017", currentRevision = 6, lastModified = "30/10/2017", lastModifiedBy = "Shaik Khader", reviewers = {
		"Dane", "Mohan" })
 class _2_Declaring_AT {
	public static void main(String... args) {

	}

}

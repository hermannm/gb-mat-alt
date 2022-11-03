package dev.hermannm.gruvbox_plain.csharp

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import dev.hermannm.gruvbox_plain.keywordHighlighting
import dev.hermannm.gruvbox_plain.languageConstantHighlighting
import dev.hermannm.gruvbox_plain.primitiveTypeHighlighting
import dev.hermannm.gruvbox_plain.punctuationHighlighting
import dev.hermannm.gruvbox_plain.highlightElement

class CsharpAnnotator : Annotator {
    override fun annotate(element: PsiElement, annotationHolder: AnnotationHolder) {
        val highlighting = when (element.text) {
            "=>" -> keywordHighlighting
            "this", "true", "false", "null" -> languageConstantHighlighting
            "object",
            "string",
            "dynamic",
            "bool",
            "byte",
            "sbyte",
            "char",
            "decimal",
            "double",
            "float",
            "int",
            "uint",
            "nint",
            "nuint",
            "long",
            "ulong",
            "short",
            "ushort",
            "void" -> primitiveTypeHighlighting
            "<", ">" -> punctuationHighlighting
            else -> return
        }

        highlightElement(highlighting, element, annotationHolder)
    }
}
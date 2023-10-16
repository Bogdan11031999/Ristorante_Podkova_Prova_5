package com.example.ristorante_podkova_prova_5

import android.content.Context
import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import android.os.Bundle
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.print.PrintManager
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class PDFGenerator(context: Context) {

    private val mContext = context

    /*
            private const val KEY_ID_ANTIPASTIFREDDI = "id_antipasti_freddi"
        private const val TABLE_ANTIPASTIFREDDI = "antipastifreddi"
        private const val TABLE_ANTIPASTICALDI = "antipasticaldi"
        private const val KEY_ID_ANTIPASTICALDI = "id_antipasti_caldi"
        private const val KEY_ID_CAVIALE = "id_caviale"
        private const val TABLE_CAVIALE = "caviale"
        private const val KEY_ID_PRIMI = "id_primi"
        private const val TABLE_PRIMI = "primi"
        private const val KEY_ID_SECONDICARNE = "id_secondicarne"
        private const val TABLE_SECONDICARNE = "secondicarne"
        private const val KEY_ID_SECONDIPESCE = "id_secondipesce"
        private const val TABLE_SECONDIPESCE = "secondipesce"
        private const val KEY_ID_CONTORNI = "id_contorni"
        private const val TABLE_CONTORNI = "contorni"
        private const val KEY_ID_DESERT = "id_desert"
        private const val TABLE_DESERT = "desert"
     */

    fun generateAndPrintPDF(outputFilePath: String, dataMapAntipastiFreddi: Map<String, Double>,dataMapAntipastiCaldi: Map<String, Double>,
    dataMapCaviale: Map<String, Double>,dataMapPrimi: Map<String, Double>,dataMapSecondiCarne: Map<String, Double>,
    dataMapSecondiPesce: Map<String, Double>,dataMapContorni: Map<String, Double>,dataMapDesert: Map<String, Double>,) {
        try {
            val document = Document()
            val outputFile = File(outputFilePath)
            PdfWriter.getInstance(document, FileOutputStream(outputFile))
            document.open()
            val font = Font(Font.FontFamily.HELVETICA, 10f)
            if(dataMapAntipastiFreddi.size!=0||dataMapAntipastiCaldi.size!=0){
                val paragraph = Paragraph("Закуски", font)
                document.add(paragraph)
                for ((key, value) in dataMapAntipastiFreddi) {
                    val paragraph = Paragraph("$key: $value", font)
                    document.add(paragraph)
                }
                for ((key, value) in dataMapAntipastiCaldi) {
                    val paragraph = Paragraph("$key: $value", font)
                    document.add(paragraph)
                }
            }
            if(dataMapCaviale.size!=0){
                val paragraph = Paragraph("Икра", font)
                document.add(paragraph)
                for ((key, value) in dataMapCaviale) {
                    val paragraph = Paragraph("$key: $value", font)
                    document.add(paragraph)
                }
            }
            document.close()
            PDFPrinter.printPDF(mContext, outputFile)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

object PDFPrinter {

    fun printPDF(context: Context?, file: File?) {
        if (context == null || file == null || !file.exists()) {
            return
        }

        val printManager = context.getSystemService(Context.PRINT_SERVICE) as PrintManager?

        printManager?.let {
            val jobName = context.getString(R.string.app_name) + " Document"

            it.print(jobName, PDFPrintDocumentAdapter(file), null)
        }
    }

    private class PDFPrintDocumentAdapter(private val pdfFile: File) : PrintDocumentAdapter() {

        override fun onLayout(oldAttributes: PrintAttributes?, newAttributes: PrintAttributes?, cancellationSignal: CancellationSignal?, callback: LayoutResultCallback?, extras: Bundle?) {
            if (cancellationSignal?.isCanceled == true) {
                callback?.onLayoutCancelled()
                return
            }

            val builder = PrintDocumentInfo.Builder("document.pdf")
                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .setPageCount(PrintDocumentInfo.PAGE_COUNT_UNKNOWN)

            val info = builder.build()

            callback?.onLayoutFinished(info, !newAttributes?.equals(oldAttributes)!!)
        }

        override fun onWrite(pages: Array<out PageRange>?, destination: ParcelFileDescriptor?, cancellationSignal: CancellationSignal?, callback: WriteResultCallback?) {
            if (cancellationSignal?.isCanceled == true) {
                callback?.onWriteCancelled()
                return
            }

            try {
                val input = FileInputStream(pdfFile)
                val output = FileOutputStream(destination?.fileDescriptor)

                val buffer = ByteArray(1024)
                var bytesRead: Int

                while (input.read(buffer).also { bytesRead = it } != -1) {
                    output.write(buffer, 0, bytesRead)
                }

                callback?.onWriteFinished(arrayOf(PageRange.ALL_PAGES))

                input.close()
                output.close()
            } catch (e: IOException) {
                callback?.onWriteFailed(e.toString())
            }
        }
    }
}



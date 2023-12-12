package com.example.podkova_ordine

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.print.PrintManager
import com.example.ristorante_podkova_prova_5.R
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException


class PDFGenerator(context: Context) {

    fun generateAndPrintPDF(
        stringInfo: String,
        outputFilePath: String,
        dataMapAntipastiFreddi: Map<String, Double>,
        dataMapAntipastiCaldi: Map<String, Double>,
        dataMapCaviale: Map<String, Double>,
        dataMapPrimi: Map<String, Double>,
        dataMapSecondiCarne: Map<String, Double>,
        dataMapSecondiPesce: Map<String, Double>,
        dataMapContorni: Map<String, Double>,
        dataMapBevande: Map<String, Double>,
        dataMapAlco: Map<String, Double>,
        dataMapBollicine:Map<String,Double>,
        dataMapRossi:Map<String,Double>,
        dataMapBianchi:Map<String,Double>,
        dataMapGeorgiani:Map<String,Double>
    ) {
        try {
            val document = PdfDocument()
            val pageWidthMm = 1050
            val pageHeightMm = 1480
            val pageWidthPt = pageWidthMm * 2.83465f
            val pageHeightPt = pageHeightMm * 2.83465f

            val pageInfo = PdfDocument.PageInfo.Builder(pageWidthPt.toInt(), pageHeightPt.toInt(), 1).create()
            val page = document.startPage(pageInfo)
            val canvas: Canvas = page.canvas

            val paint = Paint()
            paint.color = Color.BLACK
            paint.textSize = 170f

            val paintMenu=Paint()
            paintMenu.textSize=100f
            paintMenu.color = Color.BLACK

            val translator = Translator()

            var yOffset = 100f
            var xOffset = 20f

            canvas.drawText(stringInfo, xOffset, yOffset, paintMenu)
            yOffset += 150f

            if (dataMapAntipastiFreddi.isNotEmpty() || dataMapAntipastiCaldi.isNotEmpty()) {

                for ((key, value) in dataMapAntipastiFreddi) {
                    val piatto = translator.transformFromEngToRussian("Холодные закуски", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }

                    yOffset += 200f
                }

                for ((key, value) in dataMapAntipastiCaldi) {
                    val piatto = translator.transformFromEngToRussian("Горячие закуски", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }
                    yOffset += 200f
                }

                for ((key, value) in dataMapCaviale) {
                    val piatto = translator.transformFromEngToRussian("Икра", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }

                    yOffset += 200f
                }
            }

            if (dataMapPrimi.isNotEmpty()) {
                yOffset -= 40f
                canvas.drawText("---------------------", xOffset, yOffset, paint)
                yOffset += 140f

                for ((key, value) in dataMapPrimi) {
                    val piatto = translator.transformFromEngToRussian("Первые блюда", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }
                    yOffset += 200f
                }

            }
            if (dataMapSecondiCarne.isNotEmpty() || dataMapSecondiPesce.isNotEmpty() ) {

                yOffset -= 40f
                canvas.drawText("---------------------", xOffset, yOffset, paint)
                yOffset += 140f

                for ((key, value) in dataMapSecondiCarne) {
                    val piatto = translator.transformFromEngToRussian("Вторые мясные блюда", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }
                    yOffset += 200f
                }

                for ((key, value) in dataMapSecondiPesce) {
                    val piatto = translator.transformFromEngToRussian("Вторые рыбные блюда", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }
                    yOffset += 200f
                }

            }
            if (dataMapContorni.isNotEmpty()) {

                yOffset -= 40f
                canvas.drawText("---------------------", xOffset, yOffset, paint)
                yOffset += 140f

                for ((key, value) in dataMapContorni) {
                    val piatto = translator.transformFromEngToRussian("Гарнир", key)
                    if(value!=0.3 && value!=0.5){
                        val text = "$piatto: ${value.toInt()}"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }else{
                        val text = "$piatto: $value"
                        canvas.drawText(text, xOffset, yOffset, paint)
                    }
                    yOffset += 200f
                }

            }
            if(dataMapBevande.isNotEmpty() || dataMapAlco.isNotEmpty() ||dataMapBollicine.isNotEmpty()
                || dataMapRossi.isNotEmpty() || dataMapBianchi.isNotEmpty() || dataMapGeorgiani.isNotEmpty() ){

                yOffset -= 40f
                canvas.drawText("---------------------", xOffset, yOffset, paint)
                yOffset += 140f

                if (dataMapBevande.isNotEmpty()) {
                    for ((key, value) in dataMapBevande) {
                        val piatto = translator.transformFromEngToRussian("Напитки", key)
                        if(value!=0.3 && value!=0.5){
                            val text = "$piatto: ${value.toInt()}"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }else{
                            val text = "$piatto: $value"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }
                        yOffset += 200f
                    }

                }
                if (dataMapAlco.isNotEmpty()) {
                    for ((key, value) in dataMapAlco) {
                        val piatto = translator.transformFromEngToRussian("Алкоголь", key)
                        if(value!=0.3 && value!=0.5){
                            val text = "$piatto: ${value.toInt()}"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }else{
                            val text = "$piatto: $value"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }
                        yOffset += 200f
                    }
                }
                if (dataMapBollicine.isNotEmpty()) {
                    for ((key, value) in dataMapBollicine) {
                        val piatto = translator.transformFromEngToRussian("Bollicine", key)
                        if(value!=0.3 && value!=0.5){
                            val text = "$piatto: ${value.toInt()}"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }else{
                            val text = "$piatto: $value"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }
                        yOffset += 200f
                    }
                }
                if (dataMapRossi.isNotEmpty()) {
                    for ((key, value) in dataMapRossi) {
                        val piatto = translator.transformFromEngToRussian("Vini Rossi", key)
                        if(value!=0.3 && value!=0.5){
                            val text = "$piatto: ${value.toInt()}"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }else{
                            val text = "$piatto: $value"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }
                        yOffset += 200f
                    }
                }
                if (dataMapBianchi.isNotEmpty()) {
                    for ((key, value) in dataMapBianchi) {
                        val piatto = translator.transformFromEngToRussian("Vini Bianchi", key)
                        if(value!=0.3 && value!=0.5){
                            val text = "$piatto: ${value.toInt()}"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }else{
                            val text = "$piatto: $value"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }
                        yOffset += 200f
                    }
                }
                if (dataMapGeorgiani.isNotEmpty()) {
                    for ((key, value) in dataMapGeorgiani) {
                        val piatto = translator.transformFromEngToRussian("Vini Georgiani", key)
                        if(value!=0.3 && value!=0.5){
                            val text = "$piatto: ${value.toInt()}"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }else{
                            val text = "$piatto: $value"
                            canvas.drawText(text, xOffset, yOffset, paint)
                        }
                        yOffset += 200f
                    }
                }
            }


            document.finishPage(page)

            val file = File(outputFilePath)
            val fileOutputStream = FileOutputStream(file)
            document.writeTo(fileOutputStream)
            document.close()

            fileOutputStream.flush()
            fileOutputStream.close()

            // Ora puoi usare il file PDF appena creato
            // PDFPrinter.printPDF(context, file)
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

        override fun onLayout(
            oldAttributes: PrintAttributes?,
            newAttributes: PrintAttributes?,
            cancellationSignal: CancellationSignal?,
            callback: LayoutResultCallback?,
            extras: Bundle?
        ) {
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

        override fun onWrite(
            pages: Array<out PageRange>?,
            destination: ParcelFileDescriptor?,
            cancellationSignal: CancellationSignal?,
            callback: WriteResultCallback?
        ) {
            if (cancellationSignal?.isCanceled == true) {
                callback?.onWriteCancelled()
                return
            }

            try {
                val input = FileInputStream(pdfFile)
                val output = FileOutputStream(destination?.fileDescriptor)

                val buffer = ByteArray(3024)
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



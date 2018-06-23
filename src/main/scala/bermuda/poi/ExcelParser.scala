package bermuda.poi

import java.io.{File, FileOutputStream, FileInputStream}
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.{Cell, Row, Workbook, Sheet}
import scala.collection.JavaConverters._

object ExcelParser {

  def main(args: Array[String]): Unit = {
    val myFile = new File("/Users/roy/Documents/excelsample.xlsx")

    val fis = new FileInputStream(myFile)

    val myWorkbook = new XSSFWorkbook(fis)

    val mySheet = myWorkbook.getSheetAt(0)

    val rowIterator = mySheet.iterator()
    while(rowIterator.hasNext) {
      val row = rowIterator.next()
      row.cellIterator().forEachRemaining(println)
    }
  }
}

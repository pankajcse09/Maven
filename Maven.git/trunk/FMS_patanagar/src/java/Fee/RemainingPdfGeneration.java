/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import EO.SchoolEO;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author kapil
 */
public class RemainingPdfGeneration {
    public static void main(String... s){
        String[] arId={"44535","34485","34386","40195","29916","29957","30150","36835","35421","30966","34594","26058","37139","40050","41781","41373","41585","43633","46002","46011","46080","46097"};
 GenerateScrollPDF gsp=new GenerateScrollPDF();
 FeeMath fm= new FeeMath();
 SchoolEO seo=new SchoolEO();
    seo.setSession("2014-2015");
    seo.setSemester("II");
        ArrayList list=fm.genFeeScrollRemianIdProgwiseFromExcelData(seo,arId);
        System.out.println("size: "+list.size());
      Document document = new Document();
      document.setPageSize(PageSize.A4.rotate());
      document.setMargins(0f, 0f, 0f, 0f);
//      Document document = new Document(PageSize.A4.rotate());
      String file="D:\\kapil\\NetBean 7.2 Projects Code\\FMS_Pantnagar\\build\\web\\ScrollInPDF\\remianingPdfs.pdf";
      System.out.println("FilePath: "+file);
      try{
      PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(file));
//      writer.addViewerPreference(PdfName.PRINTSCALING, PdfName.NONE);
      document.open();
      gsp.addMetaData(document);
//      addTitlePage(document);
//      System.out.println("list: "+list);
      gsp.addContent(document,list,seo);
      }catch(Exception e){System.out.println("ex: "+e.getMessage());}
      document.close();
      
      ScrollPdf sp=new ScrollPdf();
      seo.setFilename("remaningPdfs.pdf");
////      sp.addScrollPdfDetails(seo);
      System.out.println("pdf file is generated.");
    }
}

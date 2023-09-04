package com.example.demo.dummy;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.FixtureAssembly;
import com.example.demo.dto.Options;
import com.example.demo.model.ProductExcludeReport;
import com.example.demo.model.ProductIncludeReport;
import com.example.demo.model.ReportModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyReportModel {

    public static final String PRODUCT_PERFORMANCE_REPORT = "Product Performance Report / Donnees Sur Les Ventes";
    public static final String PRODUCT_EXCLUDED_REPORT = "Product Excluded Report / Articles Exclus du Planogramme";
    public static final String FIXTURE_SUMMARY =  "Fixture Summary List / Liste de Material de Presentation";  
    public static final String FIXTURE_SUMMARY_DISCLAIMER = "The quantities indicated do not take into account the size of the MOQ. "
    		+ "Please order your quantities based off the size of the fixture MOQs.";
	
	public static List<ReportModel> getReportModelList(Options choice) {
		List<ReportModel> reportModelList = new ArrayList<>();
		
		ReportModel reportModel = new ReportModel();
		reportModel.setPogName("TRUCK WALL - PROTECTION");
		reportModel.setPogNameFr("PRÉSENTOIR MURAL POUR CAMIONNETTES - PROTECTION");
		reportModel.setDisclaimer(FIXTURE_SUMMARY_DISCLAIMER);
		reportModel.setDate("2022-04-18");
		reportModel.setPogId("146212A");
		reportModel.setSide("LEFT");
		if(choice.equals(Options.EXCLUDE)) {
			reportModel.setSubHeading(PRODUCT_EXCLUDED_REPORT);
			reportModel.setReportList(getProductExcludeReportList());	
		}else if(choice.equals(Options.PERFORMANCE)) {
			reportModel.setSubHeading(PRODUCT_PERFORMANCE_REPORT);
			reportModel.setReportList(getProductPerformanceReportList());	
		}else {
			reportModel.setSubHeading(FIXTURE_SUMMARY);
			reportModel.setReportList(getFixtureSummaryList());
		}
		reportModelList.add(reportModel);
		
		return reportModelList;
	}

	private static List<?> getFixtureSummaryList() {

		List<FixtureAssembly>  fixtureSummaryList = new ArrayList<>();
		FixtureAssembly fixtureAssembly = new FixtureAssembly();
		fixtureAssembly.setId("0958523");
		fixtureAssembly.setName("BP.CLEAR4'COVERSTOCK");
		fixtureAssembly.setQty("42");
		fixtureAssembly.setFrench("");
		fixtureAssembly.setComment("");
		fixtureSummaryList.add(fixtureAssembly);
		
		fixtureAssembly = new FixtureAssembly();
		fixtureAssembly.setId("1960821");
		fixtureAssembly.setName("DECL,AMMUNTN POLCY,E");
		fixtureAssembly.setQty("1");
		fixtureAssembly.setFrench("");
		fixtureAssembly.setComment("");
		fixtureSummaryList.add(fixtureAssembly);
		
		fixtureAssembly = new FixtureAssembly();
		fixtureAssembly.setId("0954792");
		fixtureAssembly.setName("DIVDR,F/S 1X24\"ANWHT");
		fixtureAssembly.setQty("12");
		fixtureAssembly.setFrench("");
		fixtureAssembly.setComment("");
		fixtureSummaryList.add(fixtureAssembly);
		
		fixtureAssembly = new FixtureAssembly();
		fixtureAssembly.setId("0954887");
		fixtureAssembly.setName("DIVIDER 20\" AW");
		fixtureAssembly.setQty("250");
		fixtureAssembly.setFrench("");
		fixtureAssembly.setComment("");
		fixtureSummaryList.add(fixtureAssembly);

		fixtureAssembly = new FixtureAssembly();
		fixtureAssembly.setId("0958329");
		fixtureAssembly.setName("SUBSTITUTE W 1953098");
		fixtureAssembly.setQty("39");
		fixtureAssembly.setFrench("");
		fixtureAssembly.setComment("");
		fixtureSummaryList.add(fixtureAssembly);
		
		return fixtureSummaryList;
	}

	public static List<?> getProductExcludeReportList() {
		log.debug("DummyReportModel.getProductExcludeReportList()");

		List<ProductExcludeReport> productExcludeReportList = new ArrayList<>();
		ProductExcludeReport productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460923");
		productExcludeReport.setDescription("FL 1\" BLIND 23X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-18");
		productExcludeReport.setReason("");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

		productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460924");
		productExcludeReport.setDescription("FL 1\" BLIND 25X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-19 ");
		productExcludeReport.setReason("no_fit");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

		productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460927");
		productExcludeReport.setDescription("FL 1\" BLIND 27X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-20");
		productExcludeReport.setReason("not recorded");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

		productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460928");
		productExcludeReport.setDescription("FL 1\" BLIND 29X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-21 ");
		productExcludeReport.setReason("no_fit");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

		productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460929");
		productExcludeReport.setDescription("FL 1\" BLIND 36X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-22 ");
		productExcludeReport.setReason("no_fit");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

		productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460930");
		productExcludeReport.setDescription("FL 1\" BLIND 34X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-23 ");
		productExcludeReport.setReason("no_fit");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

		productExcludeReport = new ProductExcludeReport();
		productExcludeReport.setSku("0460931");
		productExcludeReport.setDescription("FL 1\" BLIND 32X48\"");
		productExcludeReport.setSc("FD");
		productExcludeReport.setDate("2022-04-24 ");
		productExcludeReport.setReason("no_fit");
		productExcludeReport.setPromo("true");
		productExcludeReportList.add(productExcludeReport);

//		System.out.println("productExcludeReportList : " + productExcludeReportList.toString());
		return productExcludeReportList;
	}

	public static List<?> getProductPerformanceReportList() {
		log.debug("DummyReportModel.getProductPerformanceReportList()");
		
		List<ProductIncludeReport> productIncludeReportList = new ArrayList<>();
		ProductIncludeReport productIncludeReport = new ProductIncludeReport();
		productIncludeReport.setSegment(1);
		productIncludeReport.setSku("0530104");
		productIncludeReport.setFineline(51304);
		productIncludeReport.setBincap(20);
		productIncludeReport.setFacings(5);
		productIncludeReport.setMoq(12);
		productIncludeReport.setDescription("SUNGLO ODORABSORBR");
		productIncludeReport.setSls("328");
		productIncludeReport.setSales(0);
		productIncludeReport.setWos(2.9);
		productIncludeReport.setDetails("");
		productIncludeReportList.add(productIncludeReport);
		

		productIncludeReport = new ProductIncludeReport();
		productIncludeReport.setSegment(2);
		productIncludeReport.setSku("0460935");
		productIncludeReport.setFineline(51304);
		productIncludeReport.setBincap(20);
		productIncludeReport.setFacings(5);
		productIncludeReport.setMoq(12);
		productIncludeReport.setDescription("FL 1\" BLIND 27X64\"");
		productIncludeReport.setSls("328");
		productIncludeReport.setSales(0);
		productIncludeReport.setWos(2.9);
		productIncludeReport.setDetails("");
		productIncludeReportList.add(productIncludeReport);
		
		productIncludeReport = new ProductIncludeReport();
		productIncludeReport.setSegment(3);
		productIncludeReport.setSku("0460941");
		productIncludeReport.setFineline(51304);
		productIncludeReport.setBincap(20);
		productIncludeReport.setFacings(5);
		productIncludeReport.setMoq(12);
		productIncludeReport.setDescription("FL 1\" BLIND 46X64\"");
		productIncludeReport.setSls("26");
		productIncludeReport.setSales(0);
		productIncludeReport.setWos(57.1);
		productIncludeReport.setDetails("");
		productIncludeReportList.add(productIncludeReport);
		
		productIncludeReport = new ProductIncludeReport();
		productIncludeReport.setSegment(4);
		productIncludeReport.setSku("0460943");
		productIncludeReport.setFineline(51304);
		productIncludeReport.setBincap(20);
		productIncludeReport.setFacings(5);
		productIncludeReport.setMoq(12);
		productIncludeReport.setDescription("FL PPR SHDE 48X72");
		productIncludeReport.setSls("1");
		productIncludeReport.setSales(0);
		productIncludeReport.setWos(450.0);
		productIncludeReport.setDetails("");
		productIncludeReportList.add(productIncludeReport);
		
		for(int i=0;i<=66;i++) {
			productIncludeReport = new ProductIncludeReport();
			productIncludeReport.setSegment(4+i);
			productIncludeReport.setSku( "0"+(460943+i));
			productIncludeReport.setFineline(51304);
			productIncludeReport.setBincap(20);
			productIncludeReport.setFacings(5);
			productIncludeReport.setMoq(12);
			productIncludeReport.setDescription("FL PPR SHDE 48X72");
			productIncludeReport.setSls("1");
			productIncludeReport.setSales(0);
			productIncludeReport.setWos(450.0);
			productIncludeReport.setDetails("");
			productIncludeReportList.add(productIncludeReport);
		}
		
		return productIncludeReportList;
	}
}

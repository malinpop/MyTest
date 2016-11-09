import jd.pageobjects.JDBasePage;
import jd.pageobjects.JDHomePage;
import jd.pageobjects.JDProductDetailPage;
import jd.pageobjects.JDProductListPage;

public class JDPageFactory {
	
	public static void main(String[] args) throws Exception {

		// �򿪾�����ҳ
		JDBasePage basePage = new JDBasePage();
		basePage.openHomePage();
		
		// �ھ�����ҳ�����в�ѯ����
		JDHomePage homePage =  new JDHomePage(basePage.getDriver());
		homePage.searchProduct();
		
		// �ڲ�ѯ����б�ҳ�棬���ѡ��һ����Ʒ
		JDProductListPage listPage = new JDProductListPage(homePage.getDriver());
		listPage.clickOneProduct();
		
		// ����Ʒ��ϸ��Ϣҳ�棬���빺�ﳵ
		JDProductDetailPage detailPage = new JDProductDetailPage(listPage.getDriver());
		detailPage.addToCart();
		
	}

}

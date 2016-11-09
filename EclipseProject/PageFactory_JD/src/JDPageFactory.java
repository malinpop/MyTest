import jd.pageobjects.JDBasePage;
import jd.pageobjects.JDHomePage;
import jd.pageobjects.JDProductDetailPage;
import jd.pageobjects.JDProductListPage;

public class JDPageFactory {
	
	public static void main(String[] args) throws Exception {

		// 打开京东首页
		JDBasePage basePage = new JDBasePage();
		basePage.openHomePage();
		
		// 在京东首页，进行查询操作
		JDHomePage homePage =  new JDHomePage(basePage.getDriver());
		homePage.searchProduct();
		
		// 在查询结果列表页面，随机选择一个商品
		JDProductListPage listPage = new JDProductListPage(homePage.getDriver());
		listPage.clickOneProduct();
		
		// 在商品详细信息页面，加入购物车
		JDProductDetailPage detailPage = new JDProductDetailPage(listPage.getDriver());
		detailPage.addToCart();
		
	}

}

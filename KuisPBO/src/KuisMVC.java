public class KuisMVC {
    KuisDAO kuisDAO                 = new KuisDAO();
    KuisModel kuisModel             = new KuisModel();
    KuisView kuisView               = new KuisView();
    KuisController kuisController   = new KuisController(kuisDAO, kuisModel, kuisView);
}

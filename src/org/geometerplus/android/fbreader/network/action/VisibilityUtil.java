package org.geometerplus.android.fbreader.network.action;

import android.app.Activity;
import org.geometerplus.android.fbreader.network.TopupMenuActivity;
import org.geometerplus.android.fbreader.network.Util;
import org.geometerplus.fbreader.library.RootTree;
import org.geometerplus.fbreader.network.*;
import org.geometerplus.fbreader.network.authentication.NetworkAuthenticationManager;
import org.geometerplus.fbreader.network.tree.*;
import org.geometerplus.fbreader.network.urlInfo.UrlInfo;

public abstract class VisibilityUtil {
    private VisibilityUtil(){
        
    }
    public static boolean visible(Action action, NetworkTree tree){
        return false;
    }
    public static boolean visible(AddCustomCatalogAction action, RootTree tree){
        return true;
    }
    public static boolean visible(AddCustomCatalogAction action, AddCustomCatalogItemTree tree){
        return true;
    }
    public static boolean visible(BookAction action, NetworkBookTree tree){
        return true;
    }
    public static boolean visible(BuyBasketBooksAction action, BasketCatalogTree tree){
        return tree.canBeOpened();
    }
    public static boolean visible(CatalogAction action, NetworkCatalogTree tree){
        return true;
    }
    public static boolean visible(ClearBasketAction action, BasketCatalogTree tree){
        return tree.canBeOpened();
    }
    public static boolean visible(EditCustomCatalogAction action, NetworkCatalogRootTree tree){
        return tree.getLink() instanceof ICustomNetworkLink;
    }
    public static boolean visible(ManageCatalogsAction action, RootTree tree){
        return true;
    }
    public static boolean visible(ManageCatalogsAction action, ManageCatalogsItemTree tree){
        return true;
    }
    public static boolean visible(OpenCatalogAction action, NetworkAuthorTree tree){
        return true;
    }
    public static boolean visible(OpenCatalogAction action, NetworkSeriesTree tree){
        return true;
    }
    public static boolean visible(OpenCatalogAction action, NetworkCatalogTree tree){
        return tree.canBeOpened();
    }
    public static boolean visible(OpenInBrowserAction action, NetworkCatalogTree tree){
        final NetworkCatalogItem item = tree.Item;
        return item instanceof NetworkURLCatalogItem && item.getUrl(UrlInfo.Type.HtmlPage) != null;
    }
    public static boolean visible(ReloadCatalogAction action, NetworkCatalogTree tree){
        final NetworkCatalogItem item = tree.Item;
        return item instanceof NetworkURLCatalogItem && item.getUrl(UrlInfo.Type.Catalog) != null;
    }
    public static boolean visible(RemoveCustomCatalogAction action, NetworkCatalogRootTree tree){
        return tree.getLink() instanceof ICustomNetworkLink;
    }
    public static boolean visible(RootAction action, RootTree tree){
        return true;
    }
    public static boolean visible(RunSearchAction action, SearchCatalogTree tree){
        return action.myFromContextMenu;
    }
    public static boolean visible(RunSearchAction action, NetworkTree tree){
        return RunSearchAction.getSearchTree(tree) != null;
    }
    public static boolean visible(SignInAction action, NetworkCatalogRootTree tree){
        final NetworkAuthenticationManager mgr = tree.getLink().authenticationManager();
        return mgr != null && !mgr.mayBeAuthorised(false);
    }
    public static boolean visible(SignOutAction action, NetworkCatalogRootTree tree){
        final NetworkAuthenticationManager mgr = tree.getLink().authenticationManager();
        return mgr != null && mgr.mayBeAuthorised(false);
    }
    public static boolean visible(SignUpAction action, NetworkCatalogRootTree tree){
        final NetworkAuthenticationManager mgr = tree.getLink().authenticationManager();
        return mgr != null && !mgr.mayBeAuthorised(false) && Util.isRegistrationSupported(action.myActivity, tree.getLink());
    }
    public static boolean visible(TopupAction action, TopUpTree tree){
        return true;
    }
    public static boolean visible(TopupAction action, NetworkCatalogRootTree tree){
        final INetworkLink link = tree.getLink();
        final NetworkAuthenticationManager mgr = link.authenticationManager();
        return
                mgr != null &&
                        mgr.mayBeAuthorised(false) &&
                        mgr.currentAccount() != null &&
                        TopupMenuActivity.isTopupSupported(link);
    }
}

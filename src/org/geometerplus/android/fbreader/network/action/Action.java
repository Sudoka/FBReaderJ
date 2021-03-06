/*
 * Copyright (C) 2010-2013 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader.network.action;

import android.app.Activity;

import org.geometerplus.fbreader.network.NetworkTree;
import org.geometerplus.fbreader.network.NetworkLibrary;
import org.geometerplus.fbreader.network.tree.*;

public abstract class Action {
	public final int Code;
	public final int IconId;

	protected final Activity myActivity;
	private final String myResourceKey;

	protected Action(Activity activity, int code, String resourceKey, int iconId) {
		myActivity = activity;
		Code = code;
		myResourceKey = resourceKey;
		IconId = iconId;
	}

	public boolean isVisible(NetworkTree tree){
        return tree.isVisible(visitor);
    }

	public boolean isEnabled(NetworkTree tree) {
		return true;
	}

	public abstract void run(NetworkTree tree);

	public String getContextLabel(NetworkTree tree) {
		return
			NetworkLibrary.resource().getResource(myResourceKey).getValue();
	}

	public String getOptionsLabel(NetworkTree tree) {
		return
			NetworkLibrary.resource().getResource("menu").getResource(myResourceKey).getValue();
	}

    protected NetworkTreeVisibilityVisitor visitor;

    public abstract class NetworkTreeVisibilityVisitor{
        public boolean visible(NetworkTree tree){
            return false;
        }
        public boolean visible(AddCustomCatalogItemTree tree){
            return false;
        }
        public boolean visible(BasketCatalogTree tree){
            return false;
        }
        public boolean visible(ManageCatalogsItemTree tree){
            return false;
        }
        public boolean visible(NetworkAuthorTree tree){
            return false;
        }
        public boolean visible(NetworkBookTree tree){
            return false;
        }
        public boolean visible(NetworkCatalogRootTree tree){
            return false;
        }
        public boolean visible(NetworkCatalogTree tree){
            return false;
        }
        public boolean visible(NetworkSeriesTree tree){
            return false;
        }
        public boolean visible(RootTree tree){
            return false;
        }
        public boolean visible(SearchCatalogTree tree){
            return false;
        }
        public boolean visible(TopUpTree tree){
            return false;
        }
    }
}

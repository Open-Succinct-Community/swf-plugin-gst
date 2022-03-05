package com.venky.swf.plugins.gst.db.model.assets;

import com.venky.core.string.StringUtil;
import com.venky.core.util.ObjectUtil;
import com.venky.swf.db.table.ModelImpl;

public class AssetCodeImpl extends ModelImpl<AssetCode> {
    public AssetCodeImpl(AssetCode code){
        super(code);
    }
    public String getLongDescription(){
        return getProxy().getCode() + " - " + getProxy().getDescription();
    }

    public boolean isSac(){
        return ObjectUtil.isVoid(getProxy().getCode()) ? false:  getProxy().getCode().startsWith("99");
    }

    public boolean isHsn(){
        return !isSac();
    }
}

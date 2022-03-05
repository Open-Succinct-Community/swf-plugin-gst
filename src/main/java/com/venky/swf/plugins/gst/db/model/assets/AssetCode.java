package com.venky.swf.plugins.gst.db.model.assets;

import com.venky.swf.db.Database;
import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.COLUMN_SIZE;
import com.venky.swf.db.annotations.column.IS_NULLABLE;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.annotations.column.UNIQUE_KEY;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.indexing.Index;
import com.venky.swf.db.annotations.model.HAS_DESCRIPTION_FIELD;
import com.venky.swf.db.annotations.model.MENU;
import com.venky.swf.db.model.Model;
import com.venky.swf.db.model.reflection.ModelReflector;
import com.venky.swf.sql.Expression;
import com.venky.swf.sql.Operator;
import com.venky.swf.sql.Select;
import com.venky.swf.sql.parser.SQLExpressionParser.EQ;

import java.util.List;

@MENU("Catalog")
@HAS_DESCRIPTION_FIELD("LONG_DESCRIPTION")
public interface AssetCode extends Model {
    @Index
    @IS_NULLABLE(false)
    @UNIQUE_KEY
    public String getCode();
    public void setCode(String code);

    @Index
    @IS_NULLABLE(false)
    @COLUMN_SIZE(4096)
    public String getDescription();
    public void setDescription(String description);


    @IS_NULLABLE
    public Long getRentalAssetCodeId();
    public void setRentalAssetCodeId(Long RentalAssetCodeId);
    public AssetCode getRentalAssetCode();


    @IS_VIRTUAL
    @Index
    public String getLongDescription();
    public Double getGstPct();
    public void setGstPct(Double gstPct);

    @IS_VIRTUAL
    public boolean isHsn();

    @IS_VIRTUAL
    public boolean isSac();

    @COLUMN_DEF(StandardDefault.BOOLEAN_FALSE)
    boolean isDeliveredElectronically();
    public void setDeliveredElectronically(boolean deliveredElectronically);
    public static AssetCode find(String code){
        return find(code,AssetCode.class);
    }
    public static <T extends  AssetCode> T find(String code,Class<T> clazz){
        List<T> list = new Select().from(clazz).where(new Expression(ModelReflector.instance(AssetCode.class).getPool(),
                "CODE", Operator.EQ,code)).execute(1);
        return list.isEmpty() ? null : list.get(0);
    }

}

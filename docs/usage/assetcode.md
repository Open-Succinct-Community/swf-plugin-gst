# AssetCode
>Use this table to store gst code  
>This class maps to ASSET_CODE table in DB.

## Maven Dependency
### Add this dependency in pom.xml
````xml
<dependency>
    <groupId>com.github.venkatramanm.swf-all</groupId>
    <artifactId>swf-plugin-gst</artifactId>
    <version>2.11</version>
</dependency>

````
## Table Structure

| Column | DataType | Model Field|
|-|-|-|
|CODE |  String | code |
| DESCRIPTION|  String  | description|
|RENTAL_ASSET_CODE_ID  | Long| rentalAssetCodeId|  
| DELIVERED_ELECTRONICALLY | Boolean| deliveredElectronically|
| GST_PCT | Double | gstPct|
| LONG_DESCRIPTION|  String| longDescription
### Methods in AssetCode Class
> **Apart from getters and setters for columns following methods are available**
> - boolean isHsn()
> - boolean isSac()
> - static AssetCode find(String code)
> - AssetCode getRentalAssetCode()
 
### Imports required
#### Import this inside the .java file
* import com.venky.swf.plugins.gst.db.model.assets.AssetCode

## Example
### How to insert a new AssetCode

````java
public class InsertAsset{ 
    public static void main(String[] args){
        AssetCode assetCode = Database.getTable(AssetCode.class).newRecord();
        assetCode.setCode("HSN-------");
    }
}
````

### How to retrieve a AssetCode from DB using any field

````java
public class GetAsset{
    public static void main(String[] args){
        Select select = new Select().from(AssetCode.class);
        Expression expression = new Expression(select.getPool(), "RENTAL_ASSET_CODE_ID", Operator.EQ, <"rentalAssetCode">);
        List<AssetCode> assetCodes = select.where(expression).execute(1);
    }
}
````
### How to retrieve a AssetCode from DB using code

````java
public class GetAssetByCode{
    public static void main(String[] args){
        AssetCode assetCode = AssetCode.find("SAC-------");
    }
}
````










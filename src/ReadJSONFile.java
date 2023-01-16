import java.io.FileInputStream;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;

public class ReadJSONFile {
    public static void Read() throws IOException {
        String jsonTxt = IOUtils.toString(new FileInputStream("Contrats.json"));
        System.out.println("jsonTxt.length " + jsonTxt.length() + "\n");

        JSONObject root = (JSONObject) JSONSerializer.toJSON(jsonTxt);

        JSONArray contrats = root.getJSONArray("Contrat");


        JSONObject categoryObj = contrats.getJSONObject(0);

        JSONArray category = categoryObj.getJSONArray("Catégorie de soin");
        for (int j = 0; j < category.size(); j++) {
            //System.out.println(category.getString(j));


            System.out.println(category.getJSONObject(j).get("nom") + " ::: " + category.getJSONObject(j).get("code") + " ::: A="
                    + category.getJSONObject(j).getJSONArray("A").getJSONObject(0).get("valeure") + "% : "
                    + category.getJSONObject(j).getJSONArray("A").getJSONObject(0).get("max") + "$ max :: B="
                    + category.getJSONObject(j).getJSONArray("B").getJSONObject(0).get("valeure") + "% :"
                    + category.getJSONObject(j).getJSONArray("B").getJSONObject(0).get("max") + "$ max :: C="
                    + category.getJSONObject(j).getJSONArray("C").getJSONObject(0).get("valeure") + "% :"
                    + category.getJSONObject(j).getJSONArray("C").getJSONObject(0).get("max") + "$ max :: D="
                    + category.getJSONObject(j).getJSONArray("D").getJSONObject(0).get("valeure") + "% :"
                    + category.getJSONObject(j).getJSONArray("D").getJSONObject(0).get("max") + "$ amx");
        }
    }
}

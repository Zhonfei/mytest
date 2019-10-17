/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author delta
 */
public class SQLData {
    
    public static List getKeyList(){
        List list = new ArrayList();
        for (int i = 1; i < 8; i++) {
            list.add("D"+i+"_CUR");
        }
        list.add("D8TO14_CUR");
        list.add("D15TO21_CUR");
        list.add("D22TO30_CUR");
        list.add("M1_SUM_CUR");
        list.add("D31TO60_CUR");
        list.add("D61TO90_CUR");
        list.add("M3_SUM_CUR");
        list.add("D91TO180_CUR");
        list.add("D181TOY1_CUR");
        list.add("Y1TOY2_CUR");
        list.add("Y2TOY3_CUR");
        list.add("Y3TOY5_CUR");
        list.add("OY5_CUR");
        return list;
    }
    
    public static final String OVERDUEANDUNPERIODSQL = "SELECT C.COA_CODE, C.COA_PARENT_CODE, "
                + "CASE WHEN SUBSTR(C.COA_CODE, LENGTH(C.COA_CODE)-1, 2) = '02' THEN COALESCE(SUM(A.CUR_BAL),0) ELSE 0 END AS OVERDUE_CUR, "
                + "CASE WHEN SUBSTR(C.COA_CODE, LENGTH(C.COA_CODE)-1, 2) = '03' THEN COALESCE(SUM(A.CUR_BAL),0) ELSE 0 END AS UNPERIOD_CUR "
                + "FROM ALM_RPT_ITEM_BRANCH_CUR A  "
                + "LEFT JOIN ALM_COA_FACTOR_DATA B ON A.ITEM_CODE = B.FACTOR_DATA_CODE "
                + "LEFT JOIN ALM_COA_REPORT C ON B.COA_PLAN_CODE = C.COA_PLAN_CODE AND B.COA_CODE = C.ID "
                + "LEFT JOIN PUB_BRANCH_INFO_LVL D ON A.BRANCH_CODE = D.BRANCH_ID "
                + "WHERE A.DATA_DATE = '2019-06-30' AND B.COA_PLAN_CODE = 'e15a8a58e9134191b2a9e863a030af80' AND D.PARENT_BRANCH_ID = '999999' "
                + "AND SUBSTR(C.COA_CODE, LENGTH(C.COA_CODE)-1, 2) IN ('02','03') GROUP BY C.COA_CODE, C.COA_PARENT_CODE ORDER BY C.COA_CODE";
    
    public static final String FRAMESQL = "SELECT A.* , 0 AS D1_CUR, 0 AS D2_CUR, 0 AS D3_CUR, "
                + "0 AS D4_CUR, 0 AS D5_CUR, 0 AS D6_CUR, 0 AS D7_CUR,"
                + "0 AS D8TO14_CUR, 0 AS D15TO21_CUR,0 AS D22TO30_CUR,0 AS M1_SUM_CUR,"
                + "0 AS D31TO60_CUR,0 AS D61TO90_CUR, 0 AS M3_SUM_CUR,"
                + "0 AS D91TO180_CUR, 0 AS D181TOY1_CUR, 0 AS Y1TOY2_CUR, "
                + "0 AS Y2TOY3_CUR,0 AS Y3TOY5_CUR,0 AS OY5_CUR,"
                + "0 AS UNPERIOD_CUR, 0 AS OVERDUE_CUR, 0 AS TOTAL "
                + " FROM ALM_COA_REPORT A "
                + " WHERE A.COA_PLAN_CODE = 'e15a8a58e9134191b2a9e863a030af80' "
                + " AND A.COA_CODE NOT IN ("
                + " SELECT A.COA_CODE FROM ALM_COA_REPORT A "
                + " LEFT JOIN ALM_COA_REPORT B ON A.COA_PLAN_CODE = B.COA_PLAN_CODE "
                + " AND A.COA_CODE = B.COA_PARENT_CODE "
                + " WHERE A.COA_PLAN_CODE = 'e15a8a58e9134191b2a9e863a030af80' "
                + " AND NVL(B.COA_CODE, ' ') = ' ') ORDER BY A.COA_CODE";
    
    public static final String NORMALSQL = "SELECT C.COA_CODE,\n" +
"       C.COA_PARENT_CODE,\n" +
"       SUM(A.D1_CUR) AS D1_CUR,\n" +
"       SUM(A.D2_CUR) AS D2_CUR,\n" +
"       SUM(A.D3_CUR) AS D3_CUR,\n" +
"       SUM(A.D4_CUR) AS D4_CUR,\n" +
"       SUM(A.D5_CUR) AS D5_CUR,\n" +
"       SUM(A.D6_CUR) AS D6_CUR,\n" +
"       SUM(A.D7_CUR) AS D7_CUR,\n" +
"       SUM(A.D8TO14_CUR) AS D8TO14_CUR,\n" +
"       SUM(A.D15TO21_CUR) AS D15TO21_CUR,\n" +
"       SUM(A.D22TO30_CUR) AS D22TO30_CUR,\n" +
"       0 AS M1_SUM_CUR,\n" +
"       SUM(A.D31TO60_CUR) AS D31TO60_CUR,\n" +
"       SUM(A.D61TO90_CUR) AS D61TO90_CUR,\n" +
"       0 AS M3_SUM_CUR,\n" +
"       SUM(A.D91TO180_CUR) AS D91TO180_CUR,\n" +
"       SUM(A.D181TOY1_CUR) AS D181TOY1_CUR,\n" +
"       SUM(A.Y1TOY2_CUR) AS Y1TOY2_CUR,\n" +
"       SUM(A.Y2TOY3_CUR) AS Y2TOY3_CUR,\n" +
"       SUM(A.Y3TOY5_CUR) AS Y3TOY5_CUR,\n" +
"       SUM(A.OY5_CUR) AS OY5_CUR\n" +
"  FROM LIQUIDITY_ANA_SUR_TERM A\n" +
"  LEFT JOIN ALM_COA_FACTOR_DATA B\n" +
"    ON A.ITEM_CODE = B.FACTOR_DATA_CODE\n" +
"  LEFT JOIN ALM_COA_REPORT C\n" +
"    ON B.COA_PLAN_CODE = C.COA_PLAN_CODE\n" +
"   AND B.COA_CODE = C.ID\n" +
"  LEFT JOIN PUB_BRANCH_INFO_LVL D\n" +
"    ON A.BRANCH_CODE = D.BRANCH_ID\n" +
" WHERE A.DATA_DATE = '2019-06-30'\n" +
"   AND B.COA_PLAN_CODE = 'e15a8a58e9134191b2a9e863a030af80'\n" +
"   and c.coa_code not in ('1003030101', '1003030201')\n" +
"   AND D.PARENT_BRANCH_ID = '999999'\n" +
" GROUP BY C.COA_CODE, C.COA_PARENT_CODE\n" +
"union all\n" +
"SELECT C.COA_CODE,\n" +
"       C.COA_PARENT_CODE,\n" +
"       SUM(A.D1_CUR) AS D1_CUR,\n" +
"       SUM(A.D2_CUR) AS D2_CUR,\n" +
"       SUM(A.D3_CUR) AS D3_CUR,\n" +
"       SUM(A.D4_CUR) AS D4_CUR,\n" +
"       SUM(A.D5_CUR) AS D5_CUR,\n" +
"       SUM(A.D6_CUR) AS D6_CUR,\n" +
"       SUM(A.D7_CUR) AS D7_CUR,\n" +
"       SUM(A.D8TO14_CUR) AS D8TO14_CUR,\n" +
"       SUM(A.D15TO21_CUR) AS D15TO21_CUR,\n" +
"       SUM(A.D22TO30_CUR) AS D22TO30_CUR,\n" +
"       0 AS M1_SUM_CUR,\n" +
"       SUM(A.D31TO60_CUR) AS D31TO60_CUR,\n" +
"       SUM(A.D61TO90_CUR) AS D61TO90_CUR,\n" +
"       0 AS M3_SUM_CUR,\n" +
"       SUM(A.D91TO180_CUR) AS D91TO180_CUR,\n" +
"       SUM(A.D181TOY1_CUR) AS D181TOY1_CUR,\n" +
"       SUM(A.Y1TOY2_CUR) AS Y1TOY2_CUR,\n" +
"       SUM(A.Y2TOY3_CUR) AS Y2TOY3_CUR,\n" +
"       SUM(A.Y3TOY5_CUR) AS Y3TOY5_CUR,\n" +
"       SUM(A.OY5_CUR) AS OY5_CUR\n" +
"  FROM LIQUIDITY_ANA_SUR_TERM A\n" +
"  LEFT JOIN ALM_COA_FACTOR_DATA B\n" +
"    ON A.ITEM_CODE = B.FACTOR_DATA_CODE\n" +
"  LEFT JOIN ALM_COA_REPORT C\n" +
"    ON B.COA_PLAN_CODE = C.COA_PLAN_CODE\n" +
"   AND B.COA_CODE = C.ID\n" +
"  LEFT JOIN PUB_BRANCH_INFO_LVL D\n" +
"    ON A.BRANCH_CODE = D.BRANCH_ID\n" +
" WHERE A.DATA_DATE = '2019-06-30'\n" +
"   AND B.COA_PLAN_CODE = 'e15a8a58e9134191b2a9e863a030af80'\n" +
"   and c.coa_code in ('1003030101')\n" +
"   and a.currency = 'RMB'\n" +
"   AND D.PARENT_BRANCH_ID = '999999'\n" +
" GROUP BY C.COA_CODE, C.COA_PARENT_CODE\n" +
"union all\n" +
"SELECT C.COA_CODE,\n" +
"       C.COA_PARENT_CODE,\n" +
"       SUM(A.D1_CUR) AS D1_CUR,\n" +
"       SUM(A.D2_CUR) AS D2_CUR,\n" +
"       SUM(A.D3_CUR) AS D3_CUR,\n" +
"       SUM(A.D4_CUR) AS D4_CUR,\n" +
"       SUM(A.D5_CUR) AS D5_CUR,\n" +
"       SUM(A.D6_CUR) AS D6_CUR,\n" +
"       SUM(A.D7_CUR) AS D7_CUR,\n" +
"       SUM(A.D8TO14_CUR) AS D8TO14_CUR,\n" +
"       SUM(A.D15TO21_CUR) AS D15TO21_CUR,\n" +
"       SUM(A.D22TO30_CUR) AS D22TO30_CUR,\n" +
"       0 AS M1_SUM_CUR,\n" +
"       SUM(A.D31TO60_CUR) AS D31TO60_CUR,\n" +
"       SUM(A.D61TO90_CUR) AS D61TO90_CUR,\n" +
"       0 AS M3_SUM_CUR,\n" +
"       SUM(A.D91TO180_CUR) AS D91TO180_CUR,\n" +
"       SUM(A.D181TOY1_CUR) AS D181TOY1_CUR,\n" +
"       SUM(A.Y1TOY2_CUR) AS Y1TOY2_CUR,\n" +
"       SUM(A.Y2TOY3_CUR) AS Y2TOY3_CUR,\n" +
"       SUM(A.Y3TOY5_CUR) AS Y3TOY5_CUR,\n" +
"       SUM(A.OY5_CUR) AS OY5_CUR\n" +
"  FROM LIQUIDITY_ANA_SUR_TERM A\n" +
"  LEFT JOIN ALM_COA_FACTOR_DATA B\n" +
"    ON A.ITEM_CODE = B.FACTOR_DATA_CODE\n" +
"  LEFT JOIN ALM_COA_REPORT C\n" +
"    ON B.COA_PLAN_CODE = C.COA_PLAN_CODE\n" +
"   AND B.COA_CODE = C.ID\n" +
"  LEFT JOIN PUB_BRANCH_INFO_LVL D\n" +
"    ON A.BRANCH_CODE = D.BRANCH_ID\n" +
" WHERE A.DATA_DATE = '2019-06-30'\n" +
"   AND B.COA_PLAN_CODE = 'e15a8a58e9134191b2a9e863a030af80'\n" +
"   and c.coa_code in ('1003030201')\n" +
"   and a.currency <> 'RMB'\n" +
"   AND D.PARENT_BRANCH_ID = '999999'\n" +
" GROUP BY C.COA_CODE, C.COA_PARENT_CODE";
}

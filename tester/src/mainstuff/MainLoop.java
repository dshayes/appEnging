/*    */ package mainstuff;
/*    */ 
/*    */ import com.google.appengine.api.rdbms.AppEngineDriver;
/*    */ import java.io.IOException;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
@SuppressWarnings("serial")
public class MainLoop extends HttpServlet
/*    */ {
	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		  try {
			main(null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
/*    */   public static void main(String[] args) 
/*    */     throws IOException, ClassNotFoundException
/*    */   {
/* 22 */     Connection con = null;
/*    */ 
/* 27 */     eligibleFighterTable eFT = new eligibleFighterTable();
/*    */     try
/*    */     {
/* 32 */       DriverManager.registerDriver(new AppEngineDriver());
/*    */ 
/* 49 */       con = DriverManager.getConnection("jdbc:google:rdbms://dhayesnumber1:gpsfighter/gpsFighterDataBase");
/*    */ 
/* 52 */       Statement stmt = con.createStatement();
/* 53 */       Statement stmtTwo = con.createStatement();
/*    */ 
/* 55 */       stmt = con.createStatement(
/* 56 */         1004, 
/* 57 */         1007);
/* 58 */       stmtTwo = con.createStatement(
/* 59 */         1004, 
/* 60 */         1007);
/*    */ 
/* 63 */       int j = 0;
/* 64 */       while (j < 10) {
/* 65 */         ResultSet rs = stmt.executeQuery("SELECT  P1.google_id, P2.google_id, P1.char_num, P2.char_num FROM `gpsFighterDataBase`.`Player` as P1, `gpsFighterDataBase`.`Player` as P2 WHERE (P1.latitude - P2.latitude)*(P1.latitude - P2.latitude) + (P1.longitude - P2.longitude)*(P1.longitude - P2.longitude) < 200 and P1.char_num <> P2.char_num;");
/*    */ 
/* 69 */         System.out.println("getting fighters");
/*    */ 
/* 72 */         while (rs.next()) {
/* 73 */           int playerOneID = rs.getInt(1);
/* 74 */           int playerTwoID = rs.getInt(2);
/* 75 */           int playerOne = rs.getInt(3);
/* 76 */           int playerTwo = rs.getInt(4);
/*    */ 
/* 81 */           if ((playerOneID != 0) && (playerTwoID != 0))
/*    */           {
/* 86 */             if (eFT.fightEligible(playerOneID, playerTwoID))
/*    */             {
/* 88 */               eFT.fighterAddCoolDown(playerOneID, playerTwoID);
/* 89 */               System.out.println("\tchar1 ID= " + playerOne + 
/* 90 */                 "\tchar2 ID = " + playerTwo);
/*    */ 
/* 95 */               String itemQuery = "Select item_id, item_type, add_atk, add_health, add_spd, add_luck, add_intel, base_dmg, end_dmg, action_num, description from `gpsFighterDataBase`.`Inventory` as Inv, `gpsFighterDataBase`.`Items` as I where " + 
/* 97 */                 playerOneID + " = Inv.char_id and Inv.equiped = 1 and Inv.item_num = I.item_id;";
/* 98 */               ResultSet itemS = stmtTwo.executeQuery(itemQuery);
/*    */               Item playerOneITwo;
/*    */               Item playerOneIOne;
/*    */              
/* 102 */               if (!itemS.next()) {
/* 103 */                 playerOneIOne = new Item();
/* 104 */                 playerOneITwo = new Item();
/*    */               }
/*    */               else
/*    */               {
/* 108 */                 playerOneIOne = new Item(itemS.getInt(2), itemS.getInt(3), itemS.getInt(4), itemS.getInt(5), itemS.getInt(6), itemS.getInt(7), itemS.getInt(8), itemS.getInt(9), itemS.getInt(10), itemS.getString(11));
/*    */                  
/* 109 */                 if (!itemS.next()) {
/* 110 */                   playerOneITwo = new Item();
/*    */                 }
/*    */                 else
/*    */                 {
/* 114 */                   playerOneITwo = new Item(itemS.getInt(2), itemS.getInt(3), itemS.getInt(4), itemS.getInt(5), itemS.getInt(6), itemS.getInt(7), itemS.getInt(8), itemS.getInt(9), itemS.getInt(10), itemS.getString(11));
/*    */                 }
/*    */               }
/* 117 */               String query = "SELECT * FROM gpsFighterDataBase.Character WHERE character_id =" + Integer.toString(playerOne) + ";";
/* 118 */               ResultSet fighterQuery = stmtTwo.executeQuery(query);
/* 119 */               fighterQuery.next();
/*    */ 
/* 121 */               Fighter fighter_One = new Fighter(fighterQuery.getInt(1), fighterQuery.getString(2), fighterQuery.getInt(3), fighterQuery.getInt(4), fighterQuery.getInt(5), fighterQuery.getInt(6), fighterQuery.getInt(7), fighterQuery.getInt(8), playerOneIOne, playerOneITwo);
/*    */ 
/* 123 */               query = "Select action_num, when_to_perform FROM `gpsFighterDataBase`.`Tactics` as T WHERE " + 
/* 125 */                 playerOneID + " = T.char;";
/* 126 */               fighterQuery = stmtTwo.executeQuery(query);
/* 127 */               int[] taticsFighter_one = new int[100];
/* 128 */               while (fighterQuery.next()) {
/* 129 */                 if (fighterQuery.getInt(1) > 0) {
/* 130 */                   taticsFighter_one[fighterQuery.getInt(1)] = fighterQuery.getInt(2);
/*    */                 }
/*    */               }
/* 133 */               fighter_One.getTactics().setFighterActionTable(taticsFighter_one);
/*    */ 
/* 136 */               itemQuery = "Select item_id, item_type, add_atk, add_health, add_spd, add_luck, add_intel, base_dmg, end_dmg, action_num, description from `gpsFighterDataBase`.`Inventory` as Inv, `gpsFighterDataBase`.`Items` as I where " + 
/* 138 */                 playerTwoID + " = Inv.char_id and Inv.equiped = 1 and Inv.item_num = I.item_id;";
/* 139 */               itemS = stmtTwo.executeQuery(itemQuery);
/*    */               Item playerTwoITwo;
/*    */               Item playerTwoIOne;
/*    */              
/* 143 */               if (!itemS.next()) {
/* 144 */                 playerTwoIOne = new Item();
/* 145 */                 playerTwoITwo = new Item();
/*    */               }
/*    */               else
/*    */               {
/* 149 */                 playerTwoIOne = new Item(itemS.getInt(2), itemS.getInt(3), itemS.getInt(4), itemS.getInt(5), itemS.getInt(6), itemS.getInt(7), itemS.getInt(8), itemS.getInt(9), itemS.getInt(10), itemS.getString(11));
/*    */                
/* 150 */                 if (!itemS.next()) {
/* 151 */                   playerTwoITwo = new Item();
/*    */                 }
/*    */                 else
/*    */                 {
/* 155 */                   playerTwoITwo = new Item(itemS.getInt(2), itemS.getInt(3), itemS.getInt(4), itemS.getInt(5), itemS.getInt(6), itemS.getInt(7), itemS.getInt(8), itemS.getInt(9), itemS.getInt(10), itemS.getString(11));
/*    */                 }
/*    */               }
/* 158 */               query = "SELECT * FROM gpsFighterDataBase.Character WHERE character_id =" + Integer.toString(playerTwo) + ";";
/* 159 */               fighterQuery = stmtTwo.executeQuery(query);
/* 160 */               fighterQuery.next();
/* 161 */               Fighter fighter_Two = new Fighter(fighterQuery.getInt(1), fighterQuery.getString(2), fighterQuery.getInt(3), fighterQuery.getInt(4), fighterQuery.getInt(5), fighterQuery.getInt(6), fighterQuery.getInt(7), fighterQuery.getInt(8), playerTwoIOne, playerTwoITwo);
/*    */ 
/* 163 */               query = "Select action_num, when_to_perform FROM `gpsFighterDataBase`.`Tactics` as T WHERE " + 
/* 165 */                 playerTwoID + " = T.char;";
/* 166 */               fighterQuery = stmtTwo.executeQuery(query);
/* 167 */               int[] taticsFighter_two = new int[100];
/* 168 */               while (fighterQuery.next()) {
/* 169 */                 if (fighterQuery.getInt(1) > 0) {
/* 170 */                   taticsFighter_two[fighterQuery.getInt(1)] = fighterQuery.getInt(2);
/*    */                 }
/*    */               }
/* 173 */               fighter_Two.getTactics().setFighterActionTable(taticsFighter_two);
/*    */ 
/* 178 */              Fighter_arena jog = new Fighter_arena(fighter_One, fighter_Two);
						jog.mainEvent();
/*    */             }
/*    */ 
/*    */           }
/*    */ 
/*    */         }
/*    */ 
/* 185 */         eFT.clearTable();
/* 186 */         j++;
/*    */       }
/*    */     }
/*    */     catch (SQLException e) {
/* 190 */       e.printStackTrace();
/*    */ 
/* 192 */       if (con != null)
/*    */         try {
/* 194 */           con.close();
/*    */         }
/*    */         catch (SQLException localSQLException1)
/*    */         {
/*    */         }
/*    */     }
/*    */     finally
/*    */     {
/* 192 */       if (con != null)
/*    */         try {
/* 194 */           con.close();
/*    */         }
/*    */         catch (SQLException localSQLException2)
/*    */         {
/*    */         }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.MainLoop
 * JD-Core Version:    0.6.2
 */
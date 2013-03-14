/*     */ package mainstuff;
/*     */ 
/*     */ import com.google.appengine.api.rdbms.AppEngineDriver;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ public class BattleLog
/*     */ {
/*     */   private StringBuffer battleLog;
/*     */   private Item victorItem;
/*     */   private int gainsXPV;
/*     */   private int gainsXPL;
/*     */   private int victorID;
/*     */   private int loserID;
/*     */ 
/*     */   public StringBuffer getBattleLog()
/*     */   {
/*  23 */     return this.battleLog;
/*     */   }
/*     */ 
/*     */   public void setBattleLog(StringBuffer battleLog)
/*     */   {
/*  29 */     this.battleLog = battleLog;
/*     */   }
/*     */ 
/*     */   public Item getVictorItem()
/*     */   {
/*  35 */     return this.victorItem;
/*     */   }
/*     */ 
/*     */   public void setVictorItem(Item victorItem)
/*     */   {
/*  41 */     this.victorItem = victorItem;
/*     */   }
/*     */ 
/*     */   public int getGainsXPV()
/*     */   {
/*  47 */     return this.gainsXPV;
/*     */   }
/*     */ 
/*     */   public void setGainsXPV(int gainsXP)
/*     */   {
/*  53 */     this.gainsXPV = gainsXP;
/*     */   }
/*     */   public void updateDatabase() throws ClassNotFoundException {
/*  56 */     Connection con = null;
/*     */     try
/*     */     {
/*  61 */       DriverManager.registerDriver(new AppEngineDriver());
/*     */ 
/*  80 */       con = DriverManager.getConnection("jdbc:google:rdbms://dhayesnumber1:gpsfighter/gpsFighterDataBase");
/*     */ 
/*  83 */       Statement stmt = con.createStatement();
/*     */ 
/*  85 */       stmt = con.createStatement(
/*  86 */         1004, 
/*  87 */         1007);
/*     */ 
/*  90 */       stmt.executeUpdate("UPDATE `gpsFighterDataBase`.`Character` SET `xp`='" + this.gainsXPV + "' WHERE `character_id`='" + this.victorID + "';");
/*  91 */       stmt.executeUpdate("UPDATE `gpsFighterDataBase`.`Character` SET `xp`='" + this.gainsXPL + "' WHERE `character_id`='" + this.loserID + "';");
/*     */ 
/*  93 */       stmt.executeUpdate("INSERT INTO `gpsFighterDataBase`.`Items` (`item_type`, `add_atk`, `add_health`, `add_spd`, `add_luck`, `add_intel`, `base_dmg`, `end_dmg`, `action_num`) VALUES ('" + 
/*  94 */         this.victorItem.getItemType() + "', '" + this.victorItem.getAddatk() + "', '" + this.victorItem.getAddHealth() + "', '" + this.victorItem.getAddSpd() + "', '" + this.victorItem.getAddLuck() + "', '" + this.victorItem.getAddIntel() + "', '" + this.victorItem.getBaseDmg() + "', '" + this.victorItem.getEndDmg() + "', '" + this.victorItem.getActionNum() + "');", 1);
/*     */ 
/*  96 */       ResultSet rs = stmt.getGeneratedKeys();
/*  97 */       rs.next();
/*  98 */       int itemID = rs.getInt(1);
/*  99 */       stmt.execute("INSERT INTO `gpsFighterDataBase`.`Inventory` (`char_id`, `item_num`, `equiped`) VALUES ('" + this.victorID + "', '" + itemID + "', '0');");
/*     */ 
/* 103 */       stmt.executeUpdate("INSERT INTO `gpsFighterDataBase`.`BattleLogs` (`char_one`, `char_two`, `log`) VALUES ('" + this.victorID + "', '" + this.loserID + "', '" + this.battleLog.toString() + "');");
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 109 */       e.printStackTrace();
/*     */ 
/* 111 */       if (con != null)
/*     */         try {
/* 113 */           con.close();
/*     */         }
/*     */         catch (SQLException localSQLException1)
/*     */         {
/*     */         }
/*     */     }
/*     */     finally
/*     */     {
/* 111 */       if (con != null)
/*     */         try {
/* 113 */           con.close();
/*     */         }
/*     */         catch (SQLException localSQLException2)
/*     */         {
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getVictorID() {
/* 122 */     return this.victorID;
/*     */   }
/*     */ 
/*     */   public void setVictorID(int victorID)
/*     */   {
/* 128 */     this.victorID = victorID;
/*     */   }
/*     */ 
/*     */   public int getLoserID()
/*     */   {
/* 134 */     return this.loserID;
/*     */   }
/*     */ 
/*     */   public void setLoserID(int loserID)
/*     */   {
/* 140 */     this.loserID = loserID;
/*     */   }
/*     */ 
/*     */   public int getGainsXPL()
/*     */   {
/* 146 */     return this.gainsXPL;
/*     */   }
/*     */ 
/*     */   public void setGainsXPL(int gainsXPL)
/*     */   {
/* 152 */     this.gainsXPL = gainsXPL;
/*     */   }
/*     */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.BattleLog
 * JD-Core Version:    0.6.2
 */
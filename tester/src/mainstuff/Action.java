/*    */ package mainstuff;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Action
/*    */ {
/*    */   private StringBuffer fighterLog;
/*    */ 
/*    */   Action()
/*    */   {
/*  8 */     this.fighterLog = new StringBuffer();
/*  9 */     this.fighterLog.append("sart fight |");
/*    */   }
/*    */   public void setFighterLog(String str) {
/* 12 */     this.fighterLog.append(str);
/*    */   }
/*    */ 
/*    */   public StringBuffer getFighterLog() {
/* 16 */     return this.fighterLog;
/*    */   }
/*    */ 
/*    */   public int performAction(Fighter player)
/*    */   {
/* 21 */     switch (player.performAction()) {
/*    */     case 1:
/* 23 */       int hp = player.getHealth();
/* 24 */       this.fighterLog.append(player.getName());
/* 25 */       this.fighterLog.append(" heals self for ");
/* 26 */       this.fighterLog.append(Integer.toString(healPlayer(player) - hp));
/* 27 */       this.fighterLog.append(" |");
/* 28 */       System.out.println(this.fighterLog);
/* 29 */       return 0;
/*    */     }
/* 31 */     Random generator = new Random();
/* 32 */     int roll = generator.nextInt(player.getAkt_poiwer()) + player.getFighterItemTwo().getEndDmg() + player.getFighterItem().getBaseDmg() + player.getFighterItemTwo().getBaseDmg();
/* 33 */     int luck = generator.nextInt(100) + 1;
/* 34 */     if (luck <= player.getLuck()) {
/* 35 */       roll *= 2;
/* 36 */       this.fighterLog.append("CRITICAL ");
/*    */     }
/* 38 */     this.fighterLog.append(player.getName());
/* 39 */     this.fighterLog.append(" attack for ");
/* 40 */     this.fighterLog.append(Integer.toString(player.getAkt_poiwer() + roll));
/* 41 */     this.fighterLog.append(" |");
/* 42 */     System.out.println(this.fighterLog);
/* 43 */     return player.getAkt_poiwer() + roll;
/*    */   }
/*    */ 
/*    */   private int healPlayer(Fighter player)
/*    */   {
/* 49 */     Random generator = new Random();
/* 50 */     int luck = generator.nextInt(100) + 1;
/*    */     int heal;
/*    */     
/* 52 */     if (luck <= player.getLuck()) {
/* 53 */       this.fighterLog.append("CRITICAL ");
/* 54 */       heal = player.getHealth() + 2 * player.getIntel();
/*    */     }
/*    */     else {
/* 57 */       heal = player.getHealth() + player.getIntel();
/* 58 */     }player.setHealth(heal);
/* 59 */     return heal;
/*    */   }
/*    */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.Action
 * JD-Core Version:    0.6.2
 */
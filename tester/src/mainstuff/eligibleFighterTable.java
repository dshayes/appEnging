/*    */ package mainstuff;
/*    */ 
/*    */ public class eligibleFighterTable
/*    */ {
/*  5 */   private int tableSize = 100;
/*    */   private int[] bigTable;
/*    */   private long startTime;
/*    */ 
/*    */   public eligibleFighterTable()
/*    */   {
/* 10 */     this.bigTable = new int[this.tableSize];
/* 11 */     this.startTime = System.nanoTime();
/*    */   }
/*    */ 
/*    */   void clearTable()
/*    */   {
/* 16 */     long endTime = System.nanoTime();
/* 17 */     if (endTime - this.startTime > 600000000000L) {
/* 18 */       System.out.println("clearning elible table");
/* 19 */       this.bigTable = new int[this.tableSize];
/* 20 */       this.startTime = endTime;
/*    */     }
/*    */   }
/*    */ 
/*    */   void fighterAddCoolDown(int playerOneID, int playerTwoID)
/*    */   {
/* 26 */     String sb = String.valueOf(playerOneID) + String.valueOf(playerTwoID);
/* 27 */     String index = sb.toString();
/*    */ 
/* 29 */     System.out.println("adding %d to table " + Integer.parseInt(index));
/* 30 */     this.bigTable[Integer.parseInt(index)] = 1;
/*    */ 
/* 33 */     String sb2 = String.valueOf(playerTwoID) + String.valueOf(playerOneID);
/* 34 */     String index2 = sb2.toString();
/*    */ 
/* 36 */     System.out.println("adding %d to table " + Integer.parseInt(index2));
/* 37 */     this.bigTable[Integer.parseInt(index2)] = 1;
/*    */   }
/*    */   boolean fightEligible(int playerOneID, int playerTwoID) {
/* 40 */     StringBuilder sb = new StringBuilder();
/* 41 */     sb.append(playerOneID);
/* 42 */     sb.append(playerTwoID);
/* 43 */     String index = sb.toString();
/*    */ 
/* 45 */     StringBuilder sb2 = new StringBuilder();
/* 46 */     sb2.append(playerTwoID);
/* 47 */     sb2.append(playerOneID);
/* 48 */     String index2 = sb.toString();
/*    */ 
/* 50 */     if ((this.bigTable[Integer.parseInt(index2)] == 1) && (this.bigTable[Integer.parseInt(index)] == 1)) {
/* 51 */       System.out.println("fighters not eligible");
/* 52 */       return false;
/*    */     }
/*    */ 
/* 55 */     System.out.println("fighters are eligible");
/* 56 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\eclipse\WEB-INF\classes\
 * Qualified Name:     myproject.eligibleFighterTable
 * JD-Core Version:    0.6.2
 */
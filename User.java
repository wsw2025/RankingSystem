public class User {
    private int rank;
    private int progress;

    public User(){
        this.rank = -8;
        this.progress = 0;
    }

    public int getRank(){
        return this.rank;
    }

    public int getProgress(){
        return this.progress;
    }

    public void incProgress(int lvl){
        if(lvl<-8 || lvl==0 || lvl>8){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        int dif;
        if(lvl<this.rank){
            if(lvl<0 && this.rank>0){
                dif=this.rank-lvl-1;
            }else{
                dif=this.rank-lvl;
            }
            if(dif==1){
                this.progress++;
            }
        }else{
            int inc;
            if(lvl>0 && this.rank<0){
                inc = lvl-this.rank-1;
            }else{
                inc = lvl-this.rank;
            }
//        System.out.println(inc);
            if(inc==0){
                this.progress+=3;
            }else{
                this.progress+=10*inc*inc;
            }
        }

        if(this.progress>=100){
//            System.out.println(this.progress);
            int rankInc = this.progress/100;
            this.progress = this.progress%100;
            while(rankInc>0){
                this.rank++;
                if(this.rank==0) this.rank=1;
                rankInc--;
            }
        }
    }

    public String toString(){
        return "User{" + "rank=" + this.rank + ", progress=" + this.progress + "}";
    }
}

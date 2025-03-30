package org.example;


public LearningCloneable App implements Cloneable
{
    public static void main( String[] args ) throws CloneNotSupportedException {
        App app=new App();
        App temp= (App) app.clone();
        System.out.println(app.hashCode() + " "+ temp.hashCode());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

export class Sisodetails{
    public static signouttime: any;
    public static logintime: any;

    setsignouttime(){
        Sisodetails.signouttime=new Date();
    }
    getsignouttime():number{
        return Sisodetails.signouttime;
    }

    setlogintime(){
        Sisodetails.logintime=new Date();
    }
    getlogintime():number{
        return Sisodetails.logintime;
    }
}
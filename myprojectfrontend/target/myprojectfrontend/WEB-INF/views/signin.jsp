<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div style="margin-bottom: -15pt">
<jsp:include page="navbar.jsp"></jsp:include>
</div>
<style>
*{
    border-radius: 0 !important;
}

html,body{

}

.registeration{
    border-top: 5px solid #2196f3;
    -webkit-box-shadow: 0px 5px 21px -2px rgba(0,0,0,0.47);
    -moz-box-shadow: 0px 5px 21px -2px rgba(0,0,0,0.47);
    box-shadow: 0px 5px 21px -2px rgba(0,0,0,0.47);
    margin-top: 100px;

}

.registerInner{
 margin: 15px;
}




.form-group{
    width: 100%;
    line-height: 50px;   
}

.signbuttons{
    margin-bottom: 35px;
    background: #2196f3;
    border: none;
}

input{
    border-top: none !important;
    border-right: none !important;
    border-left: none !important;
    border-bottom: 1px dotted #2196f3 !important;
    box-shadow: none !important;
    -webkit-box-shadow: none !important;
    -moz-box-shadow: none !important;
    -moz-transition: none !important;
    -webkit-transition: none !important;
}

.headerSign{
    color: #2196f3;
    margin-bottom: 20px;
    text-align: center;
}

.darktext{
    color: #2196f3;
}



</style>

 <!--this was made my Agil Asadi. You are free to delete this comment line and use it as you wish-->   

<div class="row col-md-8 col-md-offset-2 registeration">
    
<div class="registerInner">
        <div class="col-md-6 signUp">
            <h3 class="headerSign">Sign Up</h3>
            <form:form method="post" modelAttribute="regmodel" action="getuser">


                <div class="form-group">
                    <form:input class="form-control" type="text" name="name" id="name" placeholder="NAME" path="Name"/>
                </div>

                <div class="form-group">
                    <form:input class="form-control" type="text" name="surname" id="surname" placeholder="SURNAME" path="SurName"/>
                </div>
                <div class="form-group">
                    <form:input class="form-control" type="text" name="email" id="email" placeholder="YOUR EMAIL" path="YourEmail"/>
                </div>

                <div class="form-group ">
                    <form:input class="form-control" type="password" name="password" id="password" value="" placeholder="PASSWORD" path="Password"/>
                </div>
               

                <button type="submit" class=" signbuttons btn btn-primary">Sign Up</button>

            </form:form>
        </div>

             
             
        <div class ="col-md-6">
            <h3 class="headerSign">Sign In</h3>
            <form action="SignIn">
                
                <div class="form-group">                    
                    <input class="form-control" type="text" name="email" id="email" placeholder="YOUR EMAIL"/>
                </div>
                
                <div class="form-group">
                    <input class="form-control" type="password" name="password" id="password" placeholder="PASSWORD" value=""/>
                </div>
               
                <button type="submit" class="signbuttons btn btn-primary"> SignIn</button>

                
            </form>

            
        </div>
             
</div>
        
</div>
<jsp:include page="footer.jsp"></jsp:include>

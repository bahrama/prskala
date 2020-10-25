package ir.persikala.ui;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ir.persikala.consts.model.BrandHa;
import ir.persikala.exception.FindUserByMobileException;
import ir.persikala.service.UserServiceLocal;
import ir.persikala.user.request.insert.UserEntityRequestInsert;
import ir.persikala.user.response.findmobile.HitObject;
import ir.persikala.user.response.findmobile.Hits;

@Named
@RequestScoped
public class UserBean {

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private UserServiceLocal userServiceLocal;
	@Size(min=2,max=50)
	@NotEmpty
	@NotNull
	private String name;
	@Size(min=2,max=50)
	@NotEmpty
	@NotNull
	private String lastname;
	@Pattern(regexp="09\\d{9}" , message="شماره وارده اشتباه می باشد")
	private String mobile;
	private String email;
	@Size(min=2,max=50)
	@NotEmpty
	@NotNull
	private String password;
	@Size(min=2,max=50)
	@NotEmpty
	@NotNull
	private String password2;
	
	private UIComponent component;

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UIComponent getComponent() {
		return component;
	}



	public void setComponent(UIComponent component) {
		this.component = component;
	}



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public void findUserByMobile() {
		try {
			System.err.println(userServiceLocal.findUserByMobyle("0937915074").getHits().getHits().get(0).get_source().getLastname());
		} catch (FindUserByMobileException e) {
			System.err.println("user find error");
			e.getMessage();
		}
	}


	public void InsertUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			userServiceLocal.findUserByMobyle(this.mobile).getHits().getHits().get(0).get_source().getLastname();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "این کاربر در سیستم وجود دارد", "این کاربر در سیستم وجود دارد"));
		} catch (FindUserByMobileException e) {
			UserEntityRequestInsert userEntityRequestInsert=new UserEntityRequestInsert();
	    	userEntityRequestInsert.setCode(43434);
	    	userEntityRequestInsert.setEmail(email);
	    	userEntityRequestInsert.setLastname(lastname);
	    	userEntityRequestInsert.setMobile(mobile);
	    	userEntityRequestInsert.setName(lastname);
	    	userEntityRequestInsert.setPassword(password);
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	    	String formatted = formatter.format(new Date());
	    	userEntityRequestInsert.setRegister_date(formatted);
	    	if(this.password.equals(password2)) {
	    	userServiceLocal.InsertUser(userEntityRequestInsert);
	    	context.getPartialViewContext().getEvalScripts().add(
					"swal({title: 'موفق!',type: 'success', text: 'در اسرع وقت به شکایت شما رسیدگی میشود', confirmButtonColor: '#469408',})");
	    	}else {
	    		System.err.println(password);
	    		System.err.println(password2);
	            System.err.println(">>>>>>>>>>>>>>>>>>>" + component.getClientId());
	            context.addMessage(component.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "pass not match", null));
			}
		}
    	}
	
    public void itemPass(AjaxBehaviorEvent event) {
    	System.err.println("AAAAAAAAAAAAAAJJJJJJJJAAAAAAAAAAAX");
        FacesContext context = FacesContext.getCurrentInstance();
        this.password=event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("passw")[0];
        this.password2=event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("passw2")[0];
        }


}

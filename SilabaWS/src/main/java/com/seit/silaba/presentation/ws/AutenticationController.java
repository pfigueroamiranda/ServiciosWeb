package com.seit.silaba.presentation.ws;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.presentation.businessDelegate.IBusinessDelegatorView;
import com.seit.silaba.presentation.ws.model.SilaberModel;
import com.seit.silaba.utilities.SilabaAnswerWS;
import com.seit.silaba.utilities.SilabaError;
import com.seit.silaba.utilities.SilabaErrorCodes;
import com.seit.silaba.utilities.SilabaStatusResponse;

@RestController
@RequestMapping("/au")
public class AutenticationController {
	
	  @ManagedProperty(value = "#{BusinessDelegatorView}")
	    private IBusinessDelegatorView businessDelegatorView;
	  

	/**
	 * Método para loguear al occ en la aplicación.
	 * 
	 * @param login
	 *            - login del occ.
	 * @param password
	 *            - contraseña del occ.
	 * @return Respuesta del servidor.
	 */
	@RequestMapping(value = "/log", produces = "application/json", method = RequestMethod.POST)
	public SilabaAnswerWS  autentication(@RequestParam String login, @RequestParam String password){
		SilabaAnswerWS answerWS = new SilabaAnswerWS<Tbsilaber>();
		Tbsilaber tbSilaber =null;
		try {
			tbSilaber = cosultarUsuario(login, password);
			if(tbSilaber !=null){
				List usermodelList = new ArrayList<>();
				usermodelList.add(SilaberModel.setupModel(tbSilaber));
				answerWS.setStatus(SilabaStatusResponse.SUCCESS.name());
				answerWS.setListResponse(usermodelList);
			}else{
				answerWS.setStatus(SilabaStatusResponse.ERROR.name());
				answerWS.setError(setErrorCode(SilabaErrorCodes.LOGIN_FAIL.getCode(),
						SilabaErrorCodes.LOGIN_FAIL.getName(),  SilabaErrorCodes.LOGIN_FAIL.getName()));
			}
			
		} catch (Exception e) {
			answerWS.setStatus(SilabaStatusResponse.ERROR.name());
			answerWS.setError(setErrorCode(SilabaErrorCodes.LOGIN_FAIL.getCode(),
					SilabaErrorCodes.LOGIN_FAIL.getName(), e.getMessage()));
			e.printStackTrace();
		}
		
		return answerWS;
		
	}
	
	/**
	 * Método para loguear al occ en la aplicación.
	 * 
	 * @param login
	 *            - login del occ.
	 * @param password
	 *            - contraseña del occ.
	 * @return Respuesta del servidor.
	 */
	@RequestMapping(value = "/createSilaber", produces =  "application/json;charset=UTF-8", method = RequestMethod.POST)
	public SilabaAnswerWS  createSilaber(@RequestParam String res){
		SilabaAnswerWS answerWS = new SilabaAnswerWS<Tbsilaber>();
		ObjectMapper mapper = new ObjectMapper();
		Tbsilaber entity =null;
		try {
			SilaberModel model = mapper.readValue(res, SilaberModel.class);
			entity = SilaberModel.convertToObject(model);
			 businessDelegatorView.saveTbsilaber(entity);
			 
			if(entity.getConsecutivo()  !=null){
				answerWS.setStatus(SilabaStatusResponse.SUCCESS.name());
			}else{
				answerWS.setStatus(SilabaStatusResponse.ERROR.name());
				answerWS.setError(setErrorCode(SilabaErrorCodes.LOGIN_FAIL.getCode(),
						SilabaErrorCodes.FAIL_CREATING_SILABER.getName(),  SilabaErrorCodes.FAIL_CREATING_SILABER.getName()));
			}
			
		} catch (Exception e) {
			answerWS.setError(setErrorCode(SilabaErrorCodes.LOGIN_FAIL.getCode(),
					SilabaErrorCodes.FAIL_CREATING_SILABER.getName(),  SilabaErrorCodes.FAIL_CREATING_SILABER.getName()));
			e.printStackTrace();
		}
		
		return answerWS;
		
	}
	
	private Tbsilaber cosultarUsuario(String usuario, String contrasena ){
		Tbsilaber tbsilaber =null;
		Object[] variables = {"usuario", true, usuario, "=","contrasena", true, contrasena, "="};
        
        List<Tbsilaber> sil;
		try {
			sil = businessDelegatorView.findByCriteriaInTbsilaber(variables, null, null);
			if(!sil.isEmpty()){
				tbsilaber = sil.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tbsilaber;
	}
	public SilabaError setErrorCode(String errorCode, String errorMessage) {
		return setErrorCode(errorCode, errorMessage, null);
	}

	public SilabaError setErrorCode(String errorCode, String errorMessage, String exceptionMessage) {
		SilabaError error = new SilabaError();
		error.setCode(errorCode);
		error.setMessage(errorMessage);
		if (exceptionMessage != null) {
			error.setDevMessage(exceptionMessage);
		}
		return error;
	}	
}

 <style type="text/css">
div#mapRegister{
	width:100%;
	height:350px;
}
</style>

 				  <div class="form-group" onload="initMap()">
                                    <input type="text" class="form-control" placeholder="Your Name *" name="name" required data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Create Login *" name="login" required data-validation-required-message="Please enter your login.">
                                    <p class="help-block text-danger"></p>
                                </div>
								 <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Create Password *" name="password" required data-validation-required-message="Please enter password.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Confirm Password *" name="cpassword" required data-validation-required-message="Please confirm password.">
                                    <p class="help-block text-danger"></p>
                                </div>
								<div class="form-group">
                                    <input type="tel" pattern="[0-9]+" class="form-control" placeholder="Phone *" name="phone" required data-validation-required-message="Please write password.">
                                    <p class="help-block text-danger"></p>
                                </div>
                               
                            <div class="form-group">
                            <p>Your bloodgroup"</p>
                            <select name="bloodgroup" class="form-control">
                            <option value="1">I (0)</option>
                             <option value="2">II (A)</option>
                              <option value="3">III (B)</option>
                               <option value="4">IV (AB)</option>
                            </select>
                            <p>Rh: </p>
                            <select name="resus" class="form-control">
                            <option value="0"> - </option>
                             <option value="1"> + </option>
                             
                            </select>
                            </div>
                             <p class="help-block text-danger"> Select your city on map: </p>
                                <div id="mapRegister">Map</div>
                                <input type="text" name="x" id="x" class="form-control" value="Coordinates by X"/>
                            <input type = "text" name="y" id="y"  class="form-control" value="Coordinates by Y"/> 
                                  <div class="col-lg-12 text-center">
                                <div id="success">${error}</div>
                                <button type="submit" class="btn btn-xl">OK</button>
                            </div>
                            
                             
                                



  
    


							  
							  <div class="form-group">
							  <input type="hidden" value="${user.getName()}" name="oldLogin">
                                    <input type="text" value="${user.getName()}" class="form-control" placeholder="Your Name *" name="name" required data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger">Name</p>
                                </div>
                                <div class="form-group">
                                    <input type="text" value="${user.getLogin()}" class="form-control" placeholder="Create Login *" name="login" required data-validation-required-message="Please enter your login.">
                                    <p class="help-block text-danger">Login</p>
                                </div>
								 <div class="form-group">
                                    <input type="password"  value="${user.getPassword()}" class="form-control" placeholder="New Password *" name="password" required data-validation-required-message="Please enter password.">
                                    <p class="help-block text-danger">Password</p>
                                </div>
                                <div class="form-group">
                                    <input type="password" value="${user.getPassword()}" class="form-control" placeholder="Confirm Password *" name="cpassword" required data-validation-required-message="Please confirm password.">
                                    <p class="help-block text-danger">Confirm new password</p>
                                </div>
								<div class="form-group">
                                    <input type="tel" pattern="[0-9]+" value="${user.getPhone()}" class="form-control" placeholder="Phone *" name="phone" required data-validation-required-message="Phone should contain only digits">
                                    <p class="help-block text-danger">Phone</p>
                                </div>
                               
                            <div class="form-group">
                            <select name="bloodgroup" class="form-control" >
                            <option value="1" ${user.getBloodgroup() == '1' ? 'selected' : ''}>I (0)</option>
                             <option value="2" ${user.getBloodgroup() == '2' ? 'selected' : ''}>II (A)</option>
                              <option value="3" ${user.getBloodgroup() == '3' ? 'selected' : ''}>III (B)</option>
                               <option value="4" ${user.getBloodgroup() == '4' ? 'selected' : ''}>IV (AB)</option>
                            </select>
                            
                            <select name="resus" class="form-control">
                            <option value="0" ${user.getResus() == '0' ? 'selected' : ''}> - </option>
                             <option value="1" ${user.getResus() == '1' ? 'selected' : ''}> + </option>
                             
                            </select>
                            
                             <p class="help-block text-danger"> Your coordinates: </p>
                                
                                <input type="text" name="x" id="xCoord" value="${user.getX()}" class="form-control" />
                            <input type = "text" name="y" id="yCoord" value="${user.getY()}" class="form-control" /> 
                            
                            </div>
                                  <div class="col-lg-12 text-center">
                                <div id="success">${error}</div>
                                <button type="submit" class="btn btn-xl">OK</button>
                            </div>
                            
                             
                                
 
  
   
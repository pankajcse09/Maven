							<tr>
									<td nowrap="nowrap" width="174" id="label"><u>PCN Information</u></td>  
									
							</tr> 
								<br/>
							<tr>
								<td id="label" width="174">PCN No:</td>
									<td colspan="3" width="412"> ${creatorName} </td> 
							</tr>
							<tr>
									<td id="label" width="174">PCN STATUS:</td>
									<td colspan="3" width="412"><#if revisionNo??> ${revisionNo}</#if> </td> 
							</tr>
							<tr>
									<td id="label" width="174">Creation Date:</td>
									<td colspan="3" width="412"><#if symptom.customerKeyProcess??>${symptom.customerKeyProcess}</#if></td> 
							</tr>														
							<tr>
									<td id="label" width="174">Title:</td>
									<td colspan="3" width="412"><#if symptom.macroFaliure??>${symptom.macroFaliure}</#if></td> 
							</tr>
							<tr>
									<td id="label" width="174">Change Category:</td>
									<td colspan="3" width="412"><#if symptom.macroFaliureDetail??>${symptom.macroFaliureDetail}</#if></td> 
							</tr>
							
							
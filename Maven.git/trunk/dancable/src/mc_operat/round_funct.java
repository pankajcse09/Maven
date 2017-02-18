/*
 * Copyright 2014 kapil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mc_operat;

import java.text.DecimalFormat;

/**
 *
 * @author kapil
 */
public class round_funct {
   DecimalFormat df=new DecimalFormat("0.00");
    public String round_toTwo(double v)
    {
        return df.format(v);
    }
    
    public static void main(String ar[])
    {
        int mnths=(int) (Math.round(Double.parseDouble("5.5")*12)*100/100.0);
        System.out.println("Months: "+mnths);
    }
}

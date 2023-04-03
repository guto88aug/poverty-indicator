import {Base} from "./base.model";

export class Indicator {

  indicator: Base = new Base();
  country: Base = new Base();
  countryIso3Code: String = "";
  date: String = "";
  value: String = "";
  unit: String = "";
  obsStatus: String = "";
  decimal: Number = 0;

}

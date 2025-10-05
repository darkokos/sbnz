export type Recommendations = {
  carCharging: boolean;
  powerSource: "GRID" | "RESERVES";
  acOn: boolean;
  spaceHeaterOn: boolean;
  radiatorOn: boolean;
  floorHeatingOn: boolean;
  washingMachineOn: boolean;
  lightBrightness: number;
  boilerOn: boolean;
  dryerOn: boolean;
  airPurifierOn: boolean;
  dishWasherOn: boolean;
};

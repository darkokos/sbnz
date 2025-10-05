"use client";

import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardHeader,
  Checkbox,
  FormControlLabel,
  FormGroup,
  Grid,
  Stack,
  TextField,
  Typography,
} from "@mui/material";
import PageTemplate from "../components/PageTemplate";
import { ChangeEvent, useState } from "react";

export default function Heating() {
  type HeatingPlan = {
    targetTemperature: string;
    useAirConditioner: boolean;
    useFloorHeater: boolean;
    useRadiator: boolean;
    useSpaceHeater: boolean;
    batteryBudget: string;
    gridBudget: string;
  };

  const [heatingPlanState, setHeatingPlanState] = useState<HeatingPlan>({
    targetTemperature: "",
    useAirConditioner: false,
    useFloorHeater: false,
    useRadiator: false,
    useSpaceHeater: false,
    batteryBudget: "",
    gridBudget: "",
  });

  const [isHeatingPlanAchievable, setIsHeatingPlanAchievable] = useState<
    boolean | undefined
  >();

  const handleTextFieldChanged = (
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
  ) => {
    setHeatingPlanState({
      ...heatingPlanState,
      [e.target.name]: e.target.value,
    });
    console.log(heatingPlanState);
  };

  const handleCheckboxChanged = (e: ChangeEvent<HTMLInputElement>) => {
    setHeatingPlanState({
      ...heatingPlanState,
      [e.target.name]: e.target.checked,
    });
    console.log(heatingPlanState);
  };

  const handleSubmitClicked = () => {};

  return (
    <PageTemplate title="Heating Plan">
      <Card style={{ width: "500px" }}>
        <CardHeader title="Heating Plan" />
        <CardContent>
          <Stack gap={2}>
            <TextField
              label="Target Temperature [°C]"
              value={heatingPlanState.targetTemperature}
              onChange={handleTextFieldChanged}
              name="targetTemperature"
              fullWidth
            />
            <Stack marginX={2}>
              <Typography variant="h6">Devices To Be Used</Typography>
              <FormGroup>
                <Grid container columns={12}>
                  <Grid size={6}>
                    <FormControlLabel
                      control={
                        <Checkbox
                          checked={heatingPlanState.useAirConditioner}
                          onChange={handleCheckboxChanged}
                          name="useAirConditioner"
                        />
                      }
                      label="Air Conditioner"
                    />
                  </Grid>
                  <Grid size={6}>
                    <FormControlLabel
                      control={
                        <Checkbox
                          checked={heatingPlanState.useFloorHeater}
                          onChange={handleCheckboxChanged}
                          name="useFloorHeater"
                        />
                      }
                      label="Floor Heater"
                    />
                  </Grid>
                  <Grid size={6}>
                    <FormControlLabel
                      control={
                        <Checkbox
                          checked={heatingPlanState.useRadiator}
                          onChange={handleCheckboxChanged}
                          name="useRadiator"
                        />
                      }
                      label="Radiator"
                    />
                  </Grid>
                  <Grid size={6}>
                    <FormControlLabel
                      control={
                        <Checkbox
                          checked={heatingPlanState.useSpaceHeater}
                          onChange={handleCheckboxChanged}
                          name="useSpaceHeater"
                        />
                      }
                      label="Space Heater"
                    />
                  </Grid>
                </Grid>
              </FormGroup>
            </Stack>
            <TextField
              label="Battery Budget [kWh]"
              value={heatingPlanState.batteryBudget}
              onChange={handleTextFieldChanged}
              name="batteryBudget"
              fullWidth
            />
            <TextField
              label="Grid Budget [kWh]"
              value={heatingPlanState.gridBudget}
              onChange={handleTextFieldChanged}
              name="gridBudget"
              fullWidth
            />
          </Stack>
        </CardContent>
        <CardActions
          style={{ display: "flex", justifyContent: "end", padding: 16 }}
        >
          <Button variant="outlined" onClick={handleSubmitClicked}>
            Submit
          </Button>
        </CardActions>
      </Card>
      {isHeatingPlanAchievable === undefined || (
        <Typography
          variant="h5"
          color={isHeatingPlanAchievable ? "success" : "error"}
        >
          Heating plan {isHeatingPlanAchievable || "not"} achievable.
        </Typography>
      )}
    </PageTemplate>
  );
}

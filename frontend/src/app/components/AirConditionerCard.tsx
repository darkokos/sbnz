import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, TextField, Typography } from "@mui/material";

export default function AirConditionerCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type AirConditionerState = {
    isOn: boolean;
    targetTemperature: string;
  };

  const [state, setState] = useState<AirConditionerState>({
    isOn: false,
    targetTemperature: "",
  });

  const onSubmit = async () => {
    try {
      const response = await fetch(process.env.NEXT_PUBLIC_SERVER_URL ?? "", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(state),
      });
    } catch (error) {
      console.log(error);
      if (error) {
      }
    }
  };

  return (
    <HomeStateCardTemplate title="Air Conditioner" onSubmit={onSubmit}>
      <Stack
        direction="row"
        justifyContent="space-between"
        alignItems="center"
        paddingX={2}
      >
        <Typography>Is on:</Typography>
        <Switch
          checked={state.isOn}
          onChange={(e) => setState({ ...state, ["isOn"]: e.target.checked })}
        />
      </Stack>
      <TextField
        label="Target Temperature [°C]"
        value={state.targetTemperature}
        onChange={(e) =>
          setState({ ...state, ["targetTemperature"]: e.target.value })
        }
        fullWidth
      />
    </HomeStateCardTemplate>
  );
}

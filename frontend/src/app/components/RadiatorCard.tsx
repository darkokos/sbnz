import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, TextField, Typography } from "@mui/material";

export default function RadiatorCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type RadiatorState = {
    isOn: boolean;
    targetTemperature: string;
  };

  const [state, setState] = useState<RadiatorState>({
    isOn: false,
    targetTemperature: "",
  });

  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Radiator" onSubmit={onSubmit}>
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

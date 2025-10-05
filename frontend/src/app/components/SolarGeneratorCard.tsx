import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Box, Slider, Stack, TextField, Typography } from "@mui/material";

export default function SolarGeneratorCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type SolarGeneratorState = {
    production: string;
    currentBatteryCharge: number;
  };

  const [state, setState] = useState<SolarGeneratorState>({
    production: "",
    currentBatteryCharge: 0,
  });

  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Solar Generator" onSubmit={onSubmit}>
      <TextField
        label="Production [kWh]"
        value={state.production}
        onChange={(e) => setState({ ...state, ["production"]: e.target.value })}
        fullWidth
      />
      <Stack>
        <Typography marginLeft={2}>Current battery charge [%]:</Typography>
        <Box paddingX={2}>
          <Slider
            value={state.currentBatteryCharge}
            onChange={(_, value) =>
              setState({ ...state, ["currentBatteryCharge"]: value })
            }
            min={0}
            max={100}
            valueLabelDisplay="auto"
          />
        </Box>
      </Stack>
    </HomeStateCardTemplate>
  );
}

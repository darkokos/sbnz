import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Box, Slider, Stack, Typography } from "@mui/material";

export default function TimeReadingCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type TimeReadingState = {
    hour: number;
  };

  const [state, setState] = useState<TimeReadingState>({
    hour: 0,
  });

  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Time Reading" onSubmit={onSubmit}>
      <Stack>
        <Typography>Hour of day:</Typography>
        <Box paddingX={2}>
          <Slider
            value={state.hour}
            onChange={(_, value) => setState({ ...state, ["hour"]: value })}
            min={0}
            max={23}
            valueLabelDisplay="auto"
          />
        </Box>
      </Stack>
    </HomeStateCardTemplate>
  );
}

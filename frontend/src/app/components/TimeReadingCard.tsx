import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Box, Slider, Stack, Typography } from "@mui/material";
import { useSnackbar } from "notistack";

export default function TimeReadingCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type TimeReadingState = {
    hour: number;
  };

  const [state, setState] = useState<TimeReadingState>({
    hour: 0,
  });

  const onSubmit = () => {
    fetch(`${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/reading/time-reading`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(state),
    })
      .then((response) => {
        if (response.status > 300 || response.status < 200) {
          response
            .json()
            .then((error) => enqueueSnackbar(error, { variant: "error" }));
        } else {
          response.json().then((data) => onResultHook(data));
        }
      })
      .catch((error) => enqueueSnackbar(error, { variant: "error" }));
  };

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

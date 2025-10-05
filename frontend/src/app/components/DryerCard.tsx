import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, Typography } from "@mui/material";

export default function DryerCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type DryerState = {
    isOn: boolean;
    isLoaded: boolean;
  };

  const [state, setState] = useState<DryerState>({
    isOn: false,
    isLoaded: false,
  });

  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Dryer" onSubmit={onSubmit}>
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
      <Stack
        direction="row"
        justifyContent="space-between"
        alignItems="center"
        paddingX={2}
      >
        <Typography>Is loaded:</Typography>
        <Switch
          checked={state.isLoaded}
          onChange={(e) =>
            setState({ ...state, ["isLoaded"]: e.target.checked })
          }
        />
      </Stack>
    </HomeStateCardTemplate>
  );
}

import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, Typography } from "@mui/material";

export default function BoilerCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type BoilerState = {
    isOn: boolean;
  };

  const [state, setState] = useState<BoilerState>({
    isOn: false,
  });

  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Boiler" onSubmit={onSubmit}>
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
    </HomeStateCardTemplate>
  );
}

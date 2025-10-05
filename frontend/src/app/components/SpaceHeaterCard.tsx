import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, TextField, Typography } from "@mui/material";

export default function SpaceHeaterCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  type SpaceHeaterState = {
    isOn: boolean;
  };

  const [state, setState] = useState<SpaceHeaterState>({
    isOn: false,
  });

  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Space Heater" onSubmit={onSubmit}>
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
